package prefix;

public class Question42 {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftHeighest = new int[height.length];
        int[] rightHeightest = new int[height.length];

        // 填充左最高
        leftHeighest[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftHeighest[i] = Math.max(leftHeighest[i - 1], height[i]);
        }

        // 填充右最高
        rightHeightest[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightHeightest[i] = Math.max(rightHeightest[i + 1], height[i]);
        }

        // 计算总量
        int result = 0;
        for (int i = 1; i < n - 1; i++) {
            result += Math.max(0, Math.min(leftHeighest[i], rightHeightest[i]) - height[i]);
        }

        return result;
    }
}
