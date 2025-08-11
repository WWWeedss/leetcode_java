package tree;

public class Question98_inOrder {
    private Long lastVal = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= lastVal) {
            return false;
        }
        lastVal = (long) root.val;

        return isValidBST(root.right);
    }
}
