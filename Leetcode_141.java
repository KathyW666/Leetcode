import java.util.HashSet;
import java.util.Set;

public class Leetcode_141 {
    /**
     * AC 法1：HashSet O(n) O(n)
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while(head != null) {
            if (!set.add(head)) return true;
            else head = head.next;
        }
        return false;
    }

    /**
     * AC 法2：改变val值 O(n) O(1) tricky 会有bug
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        while(head != null) {
            if (head.val == Integer.MIN_VALUE) return true;
            else {
                head.val = Integer.MIN_VALUE;
                head = head.next;
            }
        }
        return false;
    }

    /**
     * 法3：快慢指针，有环一定有一刻相等 O(n) O(1)
     * @param head
     * @return
     */
    public boolean hasCycle3(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
