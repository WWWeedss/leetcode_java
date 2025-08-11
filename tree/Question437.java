package tree;

import java.util.HashMap;
import java.util.Map;

public class Question437 {
    int result = 0;
    Map<Long, Integer> sum2freq = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        sum2freq.put(0L, 1);
        dfs(root, 0L, targetSum);
        return result;
    }
    public void dfs(TreeNode root, Long sum, int target) {
        if (root == null) return;
        sum += root.val;
        if (sum2freq.containsKey(sum - target)) {
            result += sum2freq.get(sum - target);
        }
        sum2freq.merge(sum, 1, Integer::sum);

        dfs(root.left, sum, target);
        dfs(root.right, sum, target);

        // 恢复现场
        sum2freq.merge(sum, -1, Integer::sum);
    }
}
