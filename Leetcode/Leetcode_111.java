public class Leetcode_111 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        else return H(root, 0);
    }

    private int H(TreeNode root, int height) {
        if (root == null) return height;
        if (root.left == null) return H(root.right, height + 1);
        if (root.right == null) return H(root.left, height + 1);
        return Math.min(H(root.left, height + 1), H(root.right, height + 1));
    }

}
