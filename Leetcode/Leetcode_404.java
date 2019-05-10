public class Leetcode_404 {
    /**
     * AC 求树左叶子的和
     */
    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return sum;
        if (root.left == null && root.right == null) return sum;
        plusLeft(root, true);
        return sum;
    }

    private void plusLeft(TreeNode root, boolean isLeftLeaf) {
        if (root == null) return;
        if (root.left == null && root.right == null && isLeftLeaf) sum += root.val;
        if (root.left != null) plusLeft(root.left, true);
        if (root.right != null) plusLeft(root.right, false);
    }

}
