package anotherTime;

import java.util.ArrayDeque;
import java.util.Deque;

public class Question239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int n = nums.length;
        int[] result = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            if (i >= k && queue.peekFirst() <= i - k) {
                queue.pollFirst();
            }
            if (i + 1 >= k) {
                result[i + 1 - k] = nums[queue.peekFirst()];
            }
        }
        return result;
    }
}
