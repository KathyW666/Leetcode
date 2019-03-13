import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Leetcode_215 {

    public int findKthLargest(int[] nums, int k) {
        if (nums.length < k || k <= 0 || nums.length == 0) return Integer.MIN_VALUE;
        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > pq.peek()) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        return pq.poll();
        // Arrays.sort(nums);
        // return nums[nums.length-k];
    }

}
