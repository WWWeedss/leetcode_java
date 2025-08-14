package retrospection;

import java.util.ArrayList;
import java.util.List;

public class Question22 {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n, 0, 0, new StringBuilder());
        return result;
    }
    private void dfs(int n, int leftNumber, int rightNumber, StringBuilder path) {
        if (leftNumber == n && rightNumber == n) {
            result.add(path.toString());
        }
        if (leftNumber < n) {
            // 生成左括号
            path.append("(");
            dfs(n, leftNumber + 1, rightNumber, path);
            path.deleteCharAt(path.length() - 1);
        }

        if (leftNumber > rightNumber) {
            // 生成右括号
            path.append(")");
            dfs(n, leftNumber, rightNumber + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
