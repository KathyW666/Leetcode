import java.util.Stack;

public class Leetcode_114 {
    /**
     * 太精妙了，二叉树转成一个只有有子树的树
     * 原地！！
     */
    private TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = prev;
        prev = root;
    }

    /**
     * 用队列/堆栈做，非原地，思路比较好想
     * @param root
     */
    public void stackAns(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
            if (!stack.isEmpty()) curr.right = stack.peek();
            curr.left = null;
        }
    }
}
