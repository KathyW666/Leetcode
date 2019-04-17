import java.util.Stack;

public class Leetcode_173 {

    /**
     * AC 二叉搜索树迭代器，考察点：中序遍历，用一个stack保存所有node
     */
    class BSTIterator {

        TreeNode root;
        Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            this.root = root;
            stack = new Stack<>();
            inStack(root);
        }

        public void inStack(TreeNode root) {
            if (root == null) return;
            if (root.right != null) inStack(root.right);
            stack.push(root);
            if (root.left != null) inStack(root.left);
        }

        /** @return the next smallest number */
        public int next() {
            if (!stack.isEmpty()) {
                return stack.pop().val;
            }
            else return Integer.MIN_VALUE;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            if (stack.isEmpty()) return false;
            else return true;
        }
    }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
}
