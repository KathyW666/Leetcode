public class Leetcode_86 {
    /**
     * 链表，有小错误
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0), largeHead = new ListNode(0);
        ListNode small = smallHead, large = largeHead;
        while(head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            }
            else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null; // 一开始缺少这个导致错误，尾部记得要注明null
        small.next = largeHead.next;
        return smallHead.next;
    }
}
