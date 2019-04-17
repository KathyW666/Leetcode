import java.util.LinkedList;
import java.util.List;

public class Leetcode_113 {
    /**
     * AC 根到叶子节点的和==target
     * 注意判断叶子节点，dfs注意及时删除节点
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        dfs(res, new LinkedList<Integer>(), root, sum);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> ans, TreeNode root, int sum) {
        if (root == null) return;
        ans.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
            res.add(new LinkedList<Integer>(ans));
            ans.remove(ans.size()-1);
            return;
        }
        dfs(res, ans, root.left, sum - root.val);
        dfs(res, ans, root.right,sum - root.val);
        ans.remove(ans.size()-1);
    }
}
