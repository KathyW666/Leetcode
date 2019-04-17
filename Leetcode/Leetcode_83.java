public class Leetcode_83 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode start = new ListNode(0);
        start.next = head;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) head.next = head.next.next;
            else head = head.next;
        }
        return start.next;
    }

}
