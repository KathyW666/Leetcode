
import java.util.Comparator;
import java.util.PriorityQueue;


public class Leetcode_23 {
    /*
        为什么优先队列在操作时不能，直接全部加入，直接排序
        而是把每个数组元素的头加入，再判断是否为空，在进行add()
        或许只有add操作之后才能排序？
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0 || lists == null) return null;
        PriorityQueue<ListNode> listNodes = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) return -1;
                else if (o1.val > o2.val) return 1;
                else return 0;
            }
        });
        ListNode start = new ListNode(0);
        ListNode temp = start;

        for (ListNode node : lists)
            if (node != null)
                listNodes.add(node);

        while (!listNodes.isEmpty()) {
            temp.next = listNodes.poll();
            temp = temp.next;

            if (temp.next != null)
                listNodes.add(temp.next);
        }

        return start.next;

    }
}
