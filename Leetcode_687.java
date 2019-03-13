public class Leetcode_687 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    private int ans;

    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        helper(root);
        return ans;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int maxL = helper(root.left), maxR = helper(root.right);
        int arrowL = 0, arrowR = 0;  //非常容易错，tricky
        if (root.left != null && root.left.val == root.val) arrowL += maxL + 1;
        if (root.right != null && root.right.val == root.val) arrowR += maxR + 1;
        ans = (arrowL + arrowR) > ans ? (arrowL + arrowR) : ans;
        return arrowL > arrowR ? arrowL : arrowR;
    }

}
