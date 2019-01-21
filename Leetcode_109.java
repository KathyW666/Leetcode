import java.util.ArrayList;
import java.util.List;

public class Leetcode_109 {
    /**
     * 有序链表转二叉搜索树
     * <p>
     * 法1：循环：快慢指针找到中间值，构成树的根节点,递归
     * 时间：O(nlogn), 空间：O(logn)
     *
     * @param head 头节点
     * @return
     */
    public TreeNode sortedListToBST1(ListNode head) {
        if (head == null) return null;
        return toBST(head, null);
    }

    private TreeNode toBST(ListNode head, ListNode tail) {
        ListNode slow = head, fast = head;
        if (head == tail) return null;

        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode thead = new TreeNode(slow.val);
        thead.left = toBST(head, slow);
        thead.right = toBST(slow.next, tail);
        return thead;
    }

    /**
     * 法2：转化成数组，递归
     * 时间：O(n), 空间：O(n)
     *
     * @param head
     * @return
     */
    public TreeNode sortedListToBST2(ListNode head) {
        if (head == null) return null;
        List<Integer> lists = new ArrayList<Integer>();
        while (head != null) {
            lists.add(head.val);
            head = head.next;
        }
        return convertListToBST(lists, 0, lists.size() - 1);
    }

    private TreeNode convertListToBST(List list, int lo, int hi) {
        if (lo > hi) return null;
        int mid = lo + (hi - lo) / 2;
        TreeNode node = new TreeNode((int) list.get(mid));
        if (lo == hi) return node;
        node.left = convertListToBST(list, lo, mid - 1);
        node.right = convertListToBST(list, mid + 1, hi);
        return node;

    }

    /**
     * 法3：模拟中序遍历
     * 时间：O(n), 空间：O(logn)
     * 没太明白
     * @param head
     * @return
     */
    public TreeNode sortedListToBST3(ListNode head) {
        ListNode start = head;
        int len = 0;
        while (start != null) {
            start = start.next;
            len++;
        }
        return convert(head, 0, len - 1);
    }

    private TreeNode convert(ListNode head, int lo, int hi) {
        if (lo > hi) return null;
        int mid = (lo + hi) / 2;
        TreeNode left = convert(head, lo, mid - 1);
        TreeNode node = new TreeNode(head.val);
        node.left = left;
        head = head.next;
        node.right = convert(head, mid + 1, hi);
        return node;
    }

    public static void main(String[] args) {
        Leetcode_109 o = new Leetcode_109();
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        long startTime1 = System.nanoTime();
        TreeNode ans1 = o.sortedListToBST1(head);
        long endTime1 = System.nanoTime();
        System.out.println("Time： "+(endTime1-startTime1)+"ns");
        System.out.println(ans1);

        long startTime2 = System.nanoTime();
        TreeNode ans2 = o.sortedListToBST1(head);
        long endTime2 = System.nanoTime();
        System.out.println("Time： "+(endTime2-startTime2)+"ns");
        System.out.println(ans2);

        long startTime3 = System.nanoTime();
        TreeNode ans3 = o.sortedListToBST1(head);
        long endTime3 = System.nanoTime();
        System.out.println("Time： "+(endTime3-startTime3)+"ns");
        System.out.println(ans3);

    }

}
