package anotherTime;

import java.util.HashMap;

public class Question560 {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        HashMap<Integer, Integer> valToFreq = new HashMap<>();
        int result = 0;
        for (int i = 0; i < n + 1; i++) {
            if (valToFreq.containsKey(preSum[i] - k)) {
                result += valToFreq.get(preSum[i] - k);
            }
            valToFreq.merge(preSum[i], 1, Integer::sum);
        }
        return result;
    }
}
