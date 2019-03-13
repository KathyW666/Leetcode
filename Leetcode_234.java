import java.util.Scanner;

public class Leetcode_234 {
    /**
     * AC 判断链表是否是回文串 O(n), O(1)
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        if (head.next.next == null) return head.val == head.next.val;
        ListNode slow = head, fast = head;
        ListNode prev = null, pNext = head.next;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;  //注意fast的操作要放在前面
            slow.next = prev;
            prev = slow;
            slow = pNext;
            pNext = slow.next;
        }
        slow.next = prev;
        if (fast.next == null) slow = slow.next;
        while (slow != null && pNext != null) {
            if (slow.val != pNext.val) return false;
            slow = slow.next;
            pNext = pNext.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcode_234 o = new Leetcode_234();
        Scanner in = new Scanner(System.in);
        ListNode f = new ListNode(1);
        f.next = new ListNode(1);
        f.next.next = new ListNode(0);
        f.next.next.next = new ListNode(0);
        f.next.next.next.next = new ListNode(1);
        ListNode head = new ListNode(0);
//        while (in.hasNextInt()) {
//            int h = in.nextInt();
//            head.next = new ListNode(h);
//            head = head.next;
//        }
        System.out.println(o.isPalindrome(f));
    }
}
