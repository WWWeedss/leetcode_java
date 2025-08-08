package hash;

public class Question283 {
    public void moveZeroes(int[] nums) {
        int leftLastNonZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                nums[leftLastNonZero] = nums[i];

            }
        }
    }
}
