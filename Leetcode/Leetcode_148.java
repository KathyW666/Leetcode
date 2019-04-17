public class Leetcode_148 {
    /**
     * 单链表排序
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        return partition(head);
    }

    private ListNode partition(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode right = partition(head);
        ListNode left = partition(slow);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode(0);
        ListNode dummyhead = head;
        while (left != null || right != null) {
            if (left == null) {
                head.next = right;
                head = head.next;
                right = right.next;
            }
            else if (right == null) {
                head.next = left;
                head = head.next;
                left = left.next;
            }
            else {
                if (left.val < right.val) {
                    head.next = left;
                    head = head.next;
                    left = left.next;
                }
                else {
                    head.next = right;
                    head = head.next;
                    right = right.next;
                }
            }
        }
        return dummyhead.next;
    }
}
