public class Leetcode_82 {
    /**
     * AC 有点小难，链表去掉重复元素
     * AC的方法很复杂
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode start = head;
        ListNode prev = new ListNode(0);
        prev.next = head;
        while (start != null && start.next != null) {
            if (start.val == start.next.val) {
                while (start.next != null && start.val == start.next.val) start = start.next;
                if (prev.next == head) {
                    head = start.next;
                    prev.next = head;   // 这个地方很容易错，没有把prev的指向更新，其仍指向原head
                } else prev.next = start.next;
            } else prev = prev.next;
            start = start.next;
        }
        return head;
    }
    /**
     *  简洁明了的想法
     *  public ListNode deleteDuplicates(ListNode head) {
            if(head==null) return null;
            ListNode FakeHead=new ListNode(0);
            FakeHead.next=head;
            ListNode pre=FakeHead;
            ListNode cur=head;
            //到这里都一样，想复杂了
            while(cur!=null){
                while(cur.next!=null && cur.val==cur.next.val) cur=cur.next;
            if(pre.next==cur) pre=pre.next;
            else pre.next=cur.next;
            cur=cur.next;
            }
            return FakeHead.next;
     }
     */
}
