package slidewindow;

import java.util.ArrayList;
import java.util.List;

public class Question438 {
    public List<Integer> findAnagrams(String s, String p) {
        int dif = p.length();
        int[] char2freq = new int[1000];

        for (char c : p.toCharArray()) {
            char2freq[c]++;
        }

        if (s.length() < p.length()) return new ArrayList<>();

        for (int i = 0; i < p.length(); i++) {
            char2freq[s.charAt(i)]--;
            if (char2freq[s.charAt(i)] >= 0) dif--;
            else dif++;
        }
        List<Integer> result = new ArrayList<>();
        for (int left = 0, right = p.length(); right <= s.length(); left++, right++) {
            if (dif == 0) {
                result.add(left);
            }

            if (right == s.length()) return result;

            char2freq[s.charAt(right)]--;
            if (char2freq[s.charAt(right)] >= 0) dif--;
            else dif++;

            char2freq[s.charAt(left)]++;
            if (char2freq[s.charAt(left)] <= 0) dif--;
            else dif++;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(new Question438().findAnagrams("abab", "ab"));
    }
}
