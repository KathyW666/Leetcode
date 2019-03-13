import java.util.LinkedList;
import java.util.List;

public class Leetcode_155 {
    public class MinStack{
        private List<Integer> s;
        private int min = Integer.MAX_VALUE;
        /** LinkedList */

        public MinStack() {
            this.s = new LinkedList<Integer>();
        }

        public void push(int x) {
            s.add(x);
            if (x < min) min = x;
        }

        public void pop() {
            s.remove(s.size()-1);
        }

        public int top() {
            return s.get(s.size()-1);
        }

        public int getMin() {
            if (!s.contains(min)) {
                min = Integer.MAX_VALUE;
                int i = 0;
                while (i < s.size()) {
                    if (s.get(i) < min) min = s.get(i);
                    i++;
                }
            }
            return min;
        }

        /** 链表
        private Node head;

        public MinStack() {
        }

        public void push(int x) {
            if (head == null) head = new Node(x, x);
            else head = new Node(x, Math.min(x, head.min), head);
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.min;
        }

        private class Node {
            int val, min;
            Node next;

            private Node(int val, int min) {
                this(val, min, null);
            }

            private Node(int val, int min, Node next) {
                this.val = val;
                this.min = min;
                this.next = next;
            }
        }
         */
    }
}
