package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Question49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> storeMap = Arrays.stream(strs).collect(Collectors.groupingBy(this::calculateHash));
        return new ArrayList<>(storeMap.values());
    }

    private String calculateHash(String str) {
        // 计数
        int[] count = new int[26];
        for (char c : str.toCharArray()) {
            count[c - 'a']++;
        }
        // 将计数数组转换为字符串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                sb.append((char)('a' + i)).append(count[i]);
            }
        }
        return sb.toString();
    }

}
