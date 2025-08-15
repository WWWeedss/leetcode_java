package anotherTime;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Question128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> vals = new HashSet<>();
        for (int i : nums) {
            vals.add(i);
        }
        int result = 0;
        for (int i : vals) {
            if (!vals.contains(i - 1)) {
                int curVal = i;
                int curLength = 1;
                while(vals.contains(curVal + 1)) {
                    curLength++;
                    curVal++;
                }
                result = Math.max(result, curLength);
            }
        }
        return result;
    }
}
