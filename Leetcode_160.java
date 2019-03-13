import java.util.HashSet;
import java.util.Set;

public class Leetcode_160 {
    /** AC 暴力求解略 O(mn) */
    /**
     * AC HashSet方法 O(max(m,n)) O(max(m,n))
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> nodeSet = new HashSet<>();
        if (headA == null || headB == null) return null;
        while (headA != null || headB != null) {
            if (!nodeSet.add(headA) && headA != null) return headA;
            if (!nodeSet.add(headB) && headB != null) return headB;
            if (headA != null) headA = headA.next;
            if (headB != null) headB = headB.next;
        }
        return null;
    }

    /**
     * 双指针，每个指针遍历a和b，这样一定会和到一起
     */
    public ListNode answer(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }
}
