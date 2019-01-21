public class Leetcode_101 {
    /**
     * AC 判断是否是对称树
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if (left == null || right == null || left.val != right.val)
            return false;
        else
            return (isMirror(left.right, right.left) && isMirror(left.left, right.right));
    }
}
