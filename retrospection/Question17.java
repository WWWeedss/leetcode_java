package retrospection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question17 {
    Map<Character, String> number2Chars = new HashMap<>();
    List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return result;
        }
        number2Chars.put('2', "abc");
        number2Chars.put('3', "def");
        number2Chars.put('4', "ghi");
        number2Chars.put('5', "jkl");
        number2Chars.put('6', "mno");
        number2Chars.put('7',"pqrs");
        number2Chars.put('8',"tuv");
        number2Chars.put('9',"wxyz");
        dfs(digits, 0, new StringBuilder());
        return result;
    }

    private void dfs(String digits, int index, StringBuilder path) {
        int n = digits.length();
        if (index >= n) {
            result.add(path.toString());
            return;
        }

        char thisDigit = digits.charAt(index);
        String thisChars = number2Chars.get(thisDigit);

        for(char c : thisChars.toCharArray()) {
            path.append(c);
            dfs(digits, index + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
