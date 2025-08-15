package dp;

import java.util.Arrays;

public class Question322 {
    public int coinChange(int[] coins, int amount) {
        // dp[i] 表示凑成 i 所需要的最少硬币个数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;

        for(int i = 1; i < amount + 1; i++) {
            for (int j : coins) {
                if (j <= i) {
                    dp[i] = Math.min(dp[i], dp[i - j] + 1);
                }
            }
        }
        if (dp[amount] >= Integer.MAX_VALUE / 2) return -1;
        return dp[amount];
    }

    public static void main(String[] args) {
        new Question322().coinChange(new int[]{2}, 3);
    }
}
