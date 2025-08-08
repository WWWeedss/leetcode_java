package doublePointer;

public class Question42 {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int preMax = height[0], suffixMax = height[n - 1];
        // 因为相遇的柱子是最高的，不可以接水，所以 left == right 即可循环结束
        int result = 0;
        while(left < right) {
            if (preMax <= suffixMax) {
                // 当左侧最高偏矮时，右侧的高度无意义
                result += preMax - height[left];
                left++;
                preMax = Math.max(height[left], preMax);
            }
            else {
                // 右侧最高偏矮，左侧的高度无意义
                result += suffixMax - height[right];
                right--;
                suffixMax = Math.max(height[right], suffixMax);
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new Question42().trap(height));
    }
}
