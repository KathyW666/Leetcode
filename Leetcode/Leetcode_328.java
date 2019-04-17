public class Leetcode_328 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     * AC 链表结构变化
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode odd = head;
        ListNode evenHead = new ListNode(0);
        ListNode even = evenHead;
        while (odd.next != null && odd.next.next != null) {
            even.next = odd.next;
            odd.next = odd.next.next;
            odd = odd.next;
            even = even.next;
        }
        even.next = odd.next;
        odd.next = evenHead.next;
        return head;
    }
}
