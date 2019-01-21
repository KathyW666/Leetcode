public class Leetcode_112 {
    /**
     * AC 判断根到叶子节点的和=给出的目标值吗
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (sum == root.val && root.left == null && root.right == null) return true;
        return (hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val));
    }
}
