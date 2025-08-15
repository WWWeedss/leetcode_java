package anotherTime;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        int n = s.length();
        int maxLen = 0;
        for (String str : wordDict) {
            maxLen = Math.max(maxLen, str.length());
        }
        // dp[i] 表示 s[0:i] 是否能被 wordDict 表示
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i < n + 1; i++) {
            for (int j = i - 1; j >= Math.max(0, i - maxLen); j--) {
                String targetStr = s.substring(j, i);
                if (wordDict.contains(targetStr) && dp[j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }
}
