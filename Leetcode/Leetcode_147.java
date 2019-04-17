import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Leetcode_147 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

        public ListNode insertionSortList(ListNode head) {
            if (head == null) return null;
            List<Integer> list = new ArrayList<>();
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
            Collections.sort(list, new Comparator<Integer>(){
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1.compareTo(o2);
                }
            });
            ListNode prev = new ListNode(0);
            ListNode pHead = prev;
            for (Integer i : list) {
                prev.next = new ListNode(i);
                prev = prev.next;
            }
            return pHead.next;
        }


}
