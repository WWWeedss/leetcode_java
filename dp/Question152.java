package dp;

import java.util.Arrays;

public class Question152 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        // dp[i][0] 是在 nums[0:i + 1] 中以 nums[i] 结尾的子数组最小乘积
        // dp[i][1] 是在 nums[0:i + 1] 中以 nums[i] 结尾的子数组最大乘积
        int[][] dp = new int[n][2];
        dp[0][0] = dp[0][1] = nums[0];
        int result = dp[0][1];
        for (int i = 1; i < n; i++) {
            if (nums[i] == 0) {
                dp[i][0] = dp[i][1] = 0;
            } else if (nums[i] > 0) {
                dp[i][0] = Math.min(nums[i], nums[i] * dp[i - 1][0]);
                dp[i][1] = Math.max(nums[i], nums[i] * dp[i - 1][1]);
            } else {
                dp[i][0] = Math.min(nums[i], nums[i] * dp[i - 1][1]);
                dp[i][1] = Math.max(nums[i], nums[i] * dp[i - 1][0]);
            }
            result = Math.max(result, dp[i][1]);
        }
        return result;
    }
}
