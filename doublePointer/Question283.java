package doublePointer;

public class Question283 {
    public void moveZeroes(int[] nums) {
        int leftLastNonZero = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, leftLastNonZero++);
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
