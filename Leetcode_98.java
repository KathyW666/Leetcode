import java.util.LinkedList;
import java.util.List;

public class Leetcode_98 {
    /**
     * AC 判断是否为二叉树
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        return dfs(list, root);
    }

    private boolean dfs(List<Integer> list, TreeNode root) {
        if (root == null) return true;
        if (root.left != null)
            if (!dfs(list, root.left)) return false;
        if (list.size() == 0 || root.val > list.get(list.size()-1))
            list.add(root.val);
        else return false;
        if (root.right != null)
            if (!dfs(list, root.right)) return false;
        return true;

    }
}
