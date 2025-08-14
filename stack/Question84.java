package stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Question84 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftLower = new int[n];
        Arrays.fill(leftLower, -1);
        int[] rightLower = new int[n];
        Arrays.fill(rightLower, n);

        // 用单调栈找到左右侧第一个更矮的矩形
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                rightLower[stack.pop()] = i;
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                leftLower[stack.pop()] = i;
            }
            stack.push(i);
        }

        // 计算结果
        int result = 0;
        for (int i = 0; i < n; i++) {
            int curRectangle = (rightLower[i] - leftLower[i] - 1) * heights[i];
            result = Math.max(result, curRectangle);
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(new Question84().largestRectangleArea(new int[] {1, 1}));
    }
}
