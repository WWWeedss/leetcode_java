package hash;

import java.util.*;
import java.util.stream.Collectors;

public class Question49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resultMap = Arrays.stream(strs).collect(Collectors.groupingBy(this::calculateHash));
        return new ArrayList<>(resultMap.values());
    }
    private String calculateHash(String str) {
        int[] freq = new int[26];
        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append((char)('a' + i)).append(freq[i]);
        }
        return sb.toString();
    }
}
