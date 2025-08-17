package heap;

import java.util.*;

public class Question347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num : nums) {
            occurrences.merge(num, 1, Integer::sum);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((arr1, arr2) -> arr1[1] - arr2[1]);
        
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), freq = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < freq) {
                    queue.poll();
                    queue.offer(new int[] {num, freq});
                } 
            } else {
                queue.offer(new int[] {num, freq});
            }
        }
        
        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = queue.poll()[0];
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Question347().topKFrequent(new int[]{1, 1, 2, 2, 3}, 2)));
    }
}
