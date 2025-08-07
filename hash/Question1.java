package hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Question1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> store = new HashMap<>();
        int[] result = new int[2];

        for(int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (store.containsKey(target - x)) {
                result[0] = i;
                result[1] = store.get(target - x);
                return result;
            }
            store.put(x, i);
        }
        return new int[0];
    }
}
