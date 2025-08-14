package greedy;

public class Question45 {
    public int jump(int[] nums) {
        int curStep = 0;
        int nextStep = 0;
        int result = -1;

        for (int i = 0; i < nums.length; i++) {
            nextStep = Math.max(nextStep, i + nums[i]);
            if (i == curStep || i == nums.length - 1) {
                curStep = nextStep;
                result++;
            }
        }
        return result;
    }
}
