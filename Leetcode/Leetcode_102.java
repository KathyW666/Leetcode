import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 同103，按层序输出
 * 法1：dfs + height
 * height >= res.size() ? 增加新的list
 */
public class Leetcode_102 {
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        addLevel(res, root, 0);
        return res;
    }

    private void addLevel(List<List<Integer>> res, TreeNode root, int height) {
        if (height >= res.size()) res.add(new LinkedList<Integer>());
        res.get(height).add(root.val);
        if (root.left != null) addLevel(res, root.left, height + 1);
        if (root.right != null) addLevel(res, root.right, height + 1);
    }

    /**
     * 法2 BFS + 队列
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> ans = new LinkedList<>();
            int levelNum = queue.size();
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                ans.add(queue.poll().val);
            }
            res.add(ans);
        }
        return res;
    }
}
