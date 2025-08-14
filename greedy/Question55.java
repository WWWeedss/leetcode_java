package greedy;

public class Question55 {
    public boolean canJump(int[] nums) {
        int lastStep = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > lastStep) {
                return false;
            } else {
                lastStep = Math.max(lastStep, i + nums[i]);
            }
        }
        return true;
    }
}
