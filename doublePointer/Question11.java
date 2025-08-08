package doublePointer;

public class Question11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while(left < right) {
            maxArea = Math.max(maxArea, calculateArea(height, left, right));
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
    
    private int calculateArea(int []height, int left, int right) {
        return (right - left) * Math.min(height[left], height[right]);
    }
}
