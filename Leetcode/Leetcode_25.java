public class Leetcode_25 {

    /*
    因为用到了递归，当k>2时不是constant memory了
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode dup = head;
        ListNode n = head.next;
        while (count < k) {
            if (dup == null) return head;
            dup = dup.next;
            ++count;
        }
        head.next = reverseKGroup(dup, k);
        while (count > 1) {
            ListNode mid = n;
            n.next = head;
            head = n;
            n = mid.next;
            --count;
        }
        return head;
    }

    public ListNode reverseKGroup_A(ListNode head, int k) {
        if (head==null||head.next==null||k<2) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode tail = dummy, prev = dummy,temp;
        int count;
        while(true){
            count =k;
            while(count>0&&tail!=null){
                count--;
                tail=tail.next;
            }
            if (tail==null) break;//Has reached the end


            head=prev.next;//for next cycle
            // prev-->temp-->...--->....--->tail-->....
            // Delete @temp and insert to the next position of @tail
            // prev-->...-->...-->tail-->head-->...
            // Assign @temp to the next node of @prev
            // prev-->temp-->...-->tail-->...-->...
            // Keep doing until @tail is the next node of @prev
            while(prev.next!=tail){
                temp=prev.next;//Assign
                prev.next=temp.next;//Delete

                temp.next=tail.next;
                tail.next=temp;//Insert

            }

            tail=head;
            prev=head;

        }
        return dummy.next;
    }

}
