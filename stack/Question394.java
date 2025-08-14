package stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Question394 {
    public String decodeString(String s) {
        Deque<String> stack = new ArrayDeque<>();
        List<String> copedString = splitString(s);
        for (String str : copedString) {
            if (str.charAt(0) == ']') {
                StringBuilder targetStr = new StringBuilder();
                while (stack.peek().charAt(0) != '[') {
                    targetStr.insert(0, stack.pop());
                }
                // 吐出 [
                stack.pop();
                int number = Integer.parseInt(stack.pop());
                String newString = buildNString(targetStr.toString(), number);
                stack.push(newString);
            } else {
                stack.push(str);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    private List<String> splitString (String s) {
        // 切割为 number、[、]、和其他字符串
        List<String> result = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                if (stringBuilder.length() != 0 && !Character.isDigit(stringBuilder.charAt(0))) {
                    result.add(stringBuilder.toString());
                    // 清空字符串缓存
                    stringBuilder.setLength(0);
                }
                stringBuilder.append(c);
            } else if (c == '[') {
                // 将数字字符串加入进来
                result.add(stringBuilder.toString());
                stringBuilder.setLength(0);
                result.add(String.valueOf(c));
            } else if (c == ']') {
                if (stringBuilder.length() != 0) {
                    result.add(stringBuilder.toString());
                    stringBuilder.setLength(0);
                }
                result.add(String.valueOf(c));
            } else {
                stringBuilder.append(c);
            }
        }
        if (stringBuilder.length() != 0)
        result.add(stringBuilder.toString());
        return result;
    }

    private String buildNString(String origin, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < n; i++) {
            stringBuilder.append(origin);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Question394().decodeString("3[a2[c]]"));
    }
}
