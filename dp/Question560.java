package dp;

public class Question560 {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];

        // 构建前缀和数组
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }



    }
    public static void main(String[] args) {

    }
}
