package slidewindow;

import java.util.Scanner;

public class Question76 {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) return "";
        int resultIndex = -1;
        int minLength = Integer.MAX_VALUE;
        
        int dif = t.length();
        int[] char2freq = new int[1000];
        for (char c : t.toCharArray()) {
            char2freq[c]++;
        }
        
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char2freq[s.charAt(i)]--;
            if (char2freq[s.charAt(i)] >= 0) dif--;
            
            while(dif <= 0) {
                if (i - left + 1 < minLength) {
                    resultIndex = left;
                    minLength = i - left + 1;
                }
                char2freq[s.charAt(left)]++;
                if (char2freq[s.charAt(left)] > 0) dif++;
                left++;
            }
        }
        
        if (resultIndex == -1) return "";
        return s.substring(resultIndex, resultIndex + minLength);
    }
}
