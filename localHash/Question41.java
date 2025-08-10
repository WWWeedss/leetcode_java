package localHash;

import greedy.Question56;

public class Question41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while(nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                int j = nums[i] - 1;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            } 
        }
        
        for (int i = 0; i < n; i++) {
            if (i != nums[i] - 1) return i + 1;
        }
        return n + 1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Question41().firstMissingPositive(new int[]{2, 1}));
    }
}
