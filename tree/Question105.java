package tree;

public class Question105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return doBuildTree(preorder, 0, n - 1, inorder, 0, n - 1);
    }

    // 双闭区间
    private TreeNode doBuildTree(int[] preorder, int preLeft, int preRight,
                                 int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight) return null;
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        if (preLeft == preRight) return root;

        // 在中序遍历中找到对应的根
        int rootIndex = 0;
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        int leftTreeLength = rootIndex - inLeft;
        int rightTreeLength = inRight - rootIndex;

        TreeNode leftChild = doBuildTree(preorder, preLeft + 1, preLeft + leftTreeLength,
                inorder, inLeft, rootIndex - 1);

        TreeNode rightChild = doBuildTree(preorder, preRight - rightTreeLength + 1, preRight,
                inorder, rootIndex + 1, inRight);

        root.left = leftChild;
        root.right = rightChild;
        return root;
    }
}
