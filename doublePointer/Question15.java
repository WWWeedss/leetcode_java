package doublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.length - 1;
            int target = -nums[i];
            while(j < k) {
                if (nums[j] + nums[k] == target) {
                    // 取重复序列的最后一个 j
                    while(j < nums.length - 1 && nums[j] == nums[j + 1]) j++;
                    // 取重复序列的第一个 k
                    while(k > 0 && nums[k - 1] == nums[k]) k--;
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                } else if (nums[j] + nums[k] < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {-1,0,1,0};
        System.out.println(new Question15().threeSum(nums));
    }
}
