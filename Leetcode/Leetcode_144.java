import java.util.ArrayList;
import java.util.List;

public class Leetcode_144 {
    /**
     * AC 二叉树 前序遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(list, root);
        return list;
    }

    private void helper(List<Integer> list, TreeNode root) {
        if (root == null) return;
        list.add(root.val);
        if (root.left != null) helper(list, root.left);
        if (root.right != null) helper(list, root.right);
    }
}
