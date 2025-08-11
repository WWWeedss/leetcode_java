package hash;

import java.util.HashMap;
import java.util.Map;

public class Question560 {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];

        // 构建前缀和数组
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        Map<Integer, Integer> prefixSum2freq = new HashMap<>();
        
        int result = 0;
        for (int x : prefixSum) {
            if (prefixSum2freq.containsKey(x - k)) {
                result += prefixSum2freq.get(x - k);
            }
            prefixSum2freq.merge(x, 1, Integer::sum);
        }
        
        return result;
    }
    public static void main(String[] args) {
        
    }
}
