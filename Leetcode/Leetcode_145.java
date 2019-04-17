import java.util.ArrayList;
import java.util.List;

public class Leetcode_145 {
    /**
     * AC 二叉树 后序遍历
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }

    private void helper(List<Integer> res, TreeNode root) {
        if (root == null) return;
        if (root.left != null) helper(res, root.left);
        if (root.right != null) helper(res, root.right);
        res.add(root.val);
    }
}
