package anotherTime;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Question347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : nums) {
            freq.merge(i, 1, Integer::sum);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a1, a2) -> a1[1] - a2[1]);
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int val = entry.getKey();
            int times = entry.getValue();
            if (heap.size() < k) {
                heap.add(new int[] {val, times});
            } else {
                if (heap.peek()[1] <= times) {
                    heap.poll();
                    heap.add(new int[] {val, times});
                }
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll()[0];
        }
        return result;
    }
}
