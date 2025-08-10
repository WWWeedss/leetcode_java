package treeMap;

import java.util.TreeMap;

public class Question239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> val2freq = new TreeMap<>();
        
        int n = nums.length;
        if (n < k) return new int[0];
        int[] result = new int[n - k + 1];
        
        for (int i = 0; i < k; i++) {
            val2freq.merge(nums[i], 1, Integer::sum);
        }
        
        // 双闭区间滑动窗口
        for (int left = 0, right = k - 1; right < n; left++, right++) {
            result[left] = val2freq.lastKey();
            if (right + 1 < n) {
                val2freq.merge(nums[right + 1], 1, Integer::sum);
            }
            val2freq.merge(nums[left], -1, Integer::sum);
            if (val2freq.get(nums[left]) == 0) {
                val2freq.remove(nums[left]);
            }
        }
        
        return result;
    }
}
