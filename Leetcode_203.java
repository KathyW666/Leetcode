public class Leetcode_203 {
    /**
     * AC 去掉链表中的指定元素
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dup = new ListNode(0);
        dup.next = head;
        ListNode dupHead = dup;
        while (head != null) {
            if (head.val == val) {
                head = head.next;
                dup.next = head;
            }
            else {
                head = head.next;
                dup = dup.next;
            }
        }
        return dupHead.next;
    }
}
