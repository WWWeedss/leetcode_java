package dp;

public class Question70 {
    public int climbStairs(int n) {
        // dp[i] 表示到第 i 个台阶有多少个方法
        int[] dp = new int[n + 2];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
