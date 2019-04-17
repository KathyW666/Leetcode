public class Leetcode_19 {
    /**Given linked list: 1->2->3->4->5, and n = 2.
        After removing the second node from the end, the linked list becomes 1->2->3->5.
     **/
    // 走一遍 or 走两遍的问题，快慢指针确定尾部的第n个元素

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode slow = start;
        ListNode fast = start;
        while (fast.next != null) {
            if (n <= 0) slow = slow.next;
            fast = fast.next;
            n--;
        }
        if (slow.next != null)
            slow.next = slow.next.next;
        return start.next;
    }

}
