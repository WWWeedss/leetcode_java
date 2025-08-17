package treebfs;

import treedfs.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Question102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);

        List<List<Integer>> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            int n = queue.size();
            for(int i = 0; i < n; i++) {
                TreeNode curNode = queue.pollFirst();
                curLevel.add(curNode.val);
                if (curNode.left != null) queue.addLast(curNode.left);
                if (curNode.right != null) queue.addLast(curNode.right);
            }
            result.add(curLevel);
        }

        return result;
    }
}
