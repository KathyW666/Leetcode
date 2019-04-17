public class Leetcode_117 {
    /**
     * NA 同116，更加普通的树，需要设置dummy head，另设置一个指针去做
     * 因为next的存在，相当于可以逐层判断树，因此属于bfs的方法
     * p指针起到全部连起来的作用
     * @param root
     */
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode head = new TreeLinkNode(0);
        TreeLinkNode p = head;
        while (root != null) {
            if (root.left != null) {
                p.next = root.left;
                p = p.next;
            }
            if (root.right != null) {
                p.next = root.right;
                p = p.next;
            }
            root = root.next;
            if (root == null) { //换下一层
                p = head;
                root = head.next;
                head.next = null;
            }
        }
    }
}
