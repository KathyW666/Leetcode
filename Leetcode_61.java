public class Leetcode_61 {
    // AC 反转链表
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode start = new ListNode(0);
        ListNode end = start;
        start.next = head;
        int len = 0;
        while(end.next != null) {
            end = end.next;
            len++;
        }
        k = k % len;
        if (k == 0) return head;
        int i = 0;
        ListNode newEnd = start;
        while(i < len - k) {
            newEnd = newEnd.next;
            i++;
        }
        start.next = newEnd.next;
        end.next = head;
        newEnd.next = null;
        return start.next;
    }
}
