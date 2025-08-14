package retrospection;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Question131 {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s, 0, 0, new ArrayDeque<>());
        return result;
    }

    // 双闭区间
    private void dfs(String s, int startIndex, int curIndex, Deque<String> path) {
        int n = s.length();
        if (curIndex >= n) {
            return;
        }
        String curString = s.substring(startIndex, curIndex + 1);
        if (judgePalindrome(curString) && !curString.isEmpty()) {
            // 如果当前字符串是回文串，那么可以考虑切割
            if (curIndex == n - 1) {
                // 如果已经是最后一个字符，那么保存结果
                path.addLast(curString);
                result.add(new ArrayList<>(path));
                path.removeLast();
                return;
            }
            // 在 curIndex 切割
            path.addLast(curString);
            dfs(s, curIndex + 1, curIndex + 1, path);
            path.removeLast();
        }

        // 不在 curIndex 切割
        dfs(s, startIndex, curIndex + 1, path);
    }

    private boolean judgePalindrome(String s) {
        int n = s.length();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < n / 2; i++) {
            if (charArray[i] != charArray[n - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(new Question131().partition("aab"));
    }
}
