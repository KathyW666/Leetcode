import java.util.HashMap;

public class Leetcode_146 {
    class LRUCache {
        class DoubleLinkedNode {
            int key, value;
            DoubleLinkedNode prev, next;
            public DoubleLinkedNode() {}
            public DoubleLinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private void addNode(DoubleLinkedNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(DoubleLinkedNode node) {
            DoubleLinkedNode pPrev = node.prev;
            pPrev.next = node.next;
            node.next.prev = pPrev;
        }

        private void moveToHead(DoubleLinkedNode node) {
            removeNode(node);
            addNode(node);
        }

        private DoubleLinkedNode popTail() {
            DoubleLinkedNode last = tail.prev;
            removeNode(last);
            return last;
        }

        private HashMap<Integer, DoubleLinkedNode> cache = new HashMap<>();
        private int capacity;
        private int count;
        private DoubleLinkedNode head, tail;

        public LRUCache(int capacity) {
            this.count = 0;
            this.capacity = capacity;
            head = new DoubleLinkedNode();
            head.prev = null;
            tail = new DoubleLinkedNode();
            tail.next = null;
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DoubleLinkedNode node = cache.get(key);
            if (node == null) return -1;
            this.moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DoubleLinkedNode node = cache.get(key);
            if (node == null) {
                DoubleLinkedNode newNode = new DoubleLinkedNode(key, value);
                this.addNode(newNode);
                this.cache.put(key, newNode);
                count++;
                if (count > capacity) {
                    DoubleLinkedNode tail = this.popTail();
                    this.cache.remove(tail.key);
                    count--;
                }
            }
            else {
                node.value = value;
                this.moveToHead(node);
            }
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
