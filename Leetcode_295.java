import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Leetcode_295 {
    private Queue<Integer> minPQ;
    private Queue<Integer> maxPQ;
    /** initialize your data structure here. */
    public Leetcode_295() {
        this.minPQ = new PriorityQueue<>();
        this.maxPQ = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public void addNum(int num) {
        if (minPQ.isEmpty())  {
            minPQ.offer(num);
            return;
        }
        if (num >= minPQ.peek()) minPQ.offer(num);
        else maxPQ.offer(num);
        if (minPQ.size() - maxPQ.size() > 1) maxPQ.offer(minPQ.poll());
        else if (maxPQ.size() - minPQ.size() > 1) minPQ.offer(maxPQ.poll());
    }

    public double findMedian() {
        int diff = maxPQ.size() - minPQ.size();
        if  (diff == 0) return (minPQ.peek() + maxPQ.peek()) / 2.0;
        else if (diff > 0) return maxPQ.peek() /  1.0;
        else return minPQ.peek() /  1.0;
    }

    public static void main(String[] args) {
        Leetcode_295 o = new Leetcode_295();
        o.addNum(1);
        System.out.println(o.findMedian());
        o.addNum(2);
        System.out.println(o.findMedian());
        o.addNum(3);
        System.out.println(o.findMedian());
        o.addNum(2);
        System.out.println(o.findMedian());
    }
}
