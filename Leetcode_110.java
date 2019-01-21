public class Leetcode_110 {
    /**
     * AC 判断是否是平衡二叉树
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(judge(root.left, 0) - judge(root.right, 0)) <= 1)
            return (isBalanced(root.left) && isBalanced(root.right));
        else return false;
    }

    private int judge(TreeNode root, int height) {
        if (root == null) return height;
        return Math.max(judge(root.left, height+1), judge(root.right, height+1));
    }

    public static void main(String[] args) {
        Leetcode_110 o = new Leetcode_110();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(o.isBalanced(root));
    }
}
