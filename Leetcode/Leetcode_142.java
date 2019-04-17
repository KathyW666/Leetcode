import java.util.HashMap;
import java.util.Map;

public class Leetcode_142 {
    // AC HashMap
    public ListNode detectCycle(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>();
        int id = 0;
        while(head != null) {
            if (map.get(head) != null) return head;
            map.put(head, id);
            head = head.next;
            id++;
        }
        return null;
    }

    /**
     * 双指针方法，fast走过的距离是slow的2倍，且在相遇时比slow多走一个环
     * To let slow poiner meets fast pointer,
     * only if fast pointer run 1 cycle more than slow pointer.
     */
    public ListNode answer(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (head != slow) {
                    slow = slow.next;
                    head = head.next;
                }
                return head;
            }
        }
        return null;
    }
}
