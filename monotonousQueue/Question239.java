package monotonousQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Question239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 如果新进元素比老元素大，那这个老元素就不可能成为最大值了，删掉就好
        // 所以可以维护一个单调队列（递减）数据结构
        int n = nums.length;
        int[] result = new int[n - k + 1];
        if (k > n) return new int[0];
        Deque<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            while(!queue.isEmpty() && nums[queue.getLast()] <= nums[i]) {
                queue.pollLast();
            } 
            queue.addLast(i);
            if (i - k + 1 >= 0) {
                result[i - k + 1] = nums[queue.getFirst()];
            }
            // 如果最大的值超出了窗口
            if (i - k + 1 >= queue.getFirst()) {
                queue.pollFirst();
            }
        }
        
        return result;
    }
}
