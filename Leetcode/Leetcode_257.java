import java.util.ArrayList;
import java.util.List;

public class Leetcode_257 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, "", res);
        return res;
    }

    private void helper(TreeNode root, String s, List<String> res) {
        if (root.left == null && root.right == null) res.add(s + root.val);
        if (root.left != null) helper(root.left, s + root.val + "->", res);
        if (root.right != null) helper(root.right, s + root.val + "->", res);
    }

}
