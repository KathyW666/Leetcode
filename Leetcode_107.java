import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode_107 {
    /**
     * AC 同102，103，在加入的时候反序
     * 法1 dfs+height
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        build(res, root, 0);
        return res;
    }

    private void build(List<List<Integer>> res, TreeNode root, int height) {
        if (height >= res.size()) res.add(0, new LinkedList<Integer>());
        res.get(res.size()-1-height).add(root.val);
        if (root.left != null) build(res, root.left, height+1);
        if (root.right != null) build(res, root.right, height+1);
    }

    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> ans = new LinkedList<>();
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                ans.add(queue.poll().val);
            }
            res.add(0, ans);
        }
        return res;

    }

}
