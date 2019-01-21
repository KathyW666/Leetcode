public class Leetcode_116 {
    /**
     * NA 树链表，自顶而下的递归构建，从左->右
     * @param root
     */
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null)
                root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }

}
