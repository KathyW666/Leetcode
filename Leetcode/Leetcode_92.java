public class Leetcode_92 {
    //AC 时间O(n),空间O(1)
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode start = new ListNode(0);
        ListNode res = start;
        start.next = head;
        while (head.next != null) {
            if (m == 1) {
                ListNode pNext;
                ListNode prev = head;
                ListNode pNode = head.next;
                while (n > 1) {
                    pNext = pNode.next;
                    pNode.next = prev;
                    prev = pNode;
                    pNode = pNext;
                    n--;
                }
                head.next = pNode;
                start.next = prev;
                break;
            } else {
                head = head.next;
                start = start.next;
                m--;
                n--;
            }
        }
        return res.next;
    }


    public ListNode answer(ListNode head, int m, int n) {

        // Empty list
        if (head == null) {
            return null;
        }

        // Move the two pointers until they reach the proper starting point
        // in the list.
        ListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }

        // The two pointers that will fix the final connections.
        ListNode con = prev, tail = cur;

        // Iteratively reverse the nodes until n becomes 0.
        ListNode third = null;
        while (n > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }

        // Adjust the final connections as explained in the algorithm
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;
        return head;
    }

}
