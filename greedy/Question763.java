package greedy;

import java.util.*;

public class Question763 {
    public List<Integer> partitionLabels(String s) {
        // 构建字母下一次出现位置的数组
        int n = s.length();
        int[] nextAppear = new int[n];
        Arrays.fill(nextAppear, -1);
        // 记录上一次出现的位置
        Map<Character, Integer> lastAppear = new HashMap<>();
        // 记录下一次出现的位置
        for (int i = 0; i < n; i++) {
            char curChar = s.charAt(i);
            if (lastAppear.containsKey(curChar)) {
                int lastIndex = lastAppear.get(curChar);
                nextAppear[lastIndex] = i;
            }
            lastAppear.put(curChar, i);
        }
        List<Integer> result = new ArrayList<>();
        // 当前字符串中所含所有字母，最晚出现的 Index
        int lastCharacterIndex = 0;
        // 当前字符串长度
        int curStringLength = 1;
        for (int i = 0; i < n; i++) {
            lastCharacterIndex = Math.max(nextAppear[i], lastCharacterIndex);
            if (i == lastCharacterIndex) {
                result.add(curStringLength);
                curStringLength = 1;
                lastCharacterIndex = i + 1;
            } else {
                curStringLength++;
            }
        }
        return result;
    }
}
