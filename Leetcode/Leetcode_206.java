public class Leetcode_206 {
    /**
     * AC 反转链表 O(n), O(1)
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode pPrev = null;
        ListNode pNext = head.next;
        while (head != null) {
            head.next = pPrev;
            pPrev = head;
            head = pNext;
            if (head != null) pNext = head.next;
        }
        return pPrev;
    }
}
