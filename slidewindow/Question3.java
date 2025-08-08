package slidewindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Question3 {
    public int lengthOfLongestSubstring(String s) {
        int[] char2freq = new int[1000];
        // 双闭区间
        int left = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);
            char2freq[index]++;
            while(char2freq[index] >= 2) {
                int indexLeft = s.charAt(left);
                char2freq[indexLeft]--;
                left++;
            }
            maxLength = Math.max(maxLength, i - left + 1);
        }
        return maxLength;
    }
}
