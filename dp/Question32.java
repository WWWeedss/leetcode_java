package dp;

public class Question32 {
    public int longestValidParentheses(String s) {
        if (s.length() < 2) return 0;
        int n = s.length();
        // dp[i] 是 s[0:i] 且以 s[i - 1] 结尾的，最长有效括号子串长度
        int result = 0;
        int[] dp = new int[n + 1];
        for (int i = 2; i < n + 1; i++) {
            if (s.charAt(i - 1) == ')') {
                if (s.charAt(i - 2) == '(') {
                    dp[i] = dp[i - 2] + 2;
                } else {
                    if (i - dp[i - 1] - 2 >= 0 && s.charAt(i - dp[i - 1] - 2) == '(') {
                        dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
                    }
                }
                result = Math.max(result, dp[i]);
            }
        }
        return result;
    }
}
