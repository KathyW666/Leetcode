public class Leetcode_104 {
    /**
     * AC 求树的高度 去年Google这个都不会
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        return maxH(root, 0);
    }

    private int maxH(TreeNode root, int height) {
        if (root == null) return height;
        return Math.max(maxH(root.left, height+1), maxH(root.right, height+1));
    }
}
