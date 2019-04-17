import java.util.Deque;
import java.util.LinkedList;

public class Leetcode_239 {
    /**
     * AC 滑动窗口，没有优化，辅助deque记录当前窗口内最大值
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        Deque<Integer> q = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            operateQ(nums, i, q);
        }
        int m = 0;
        for (int i = k; i < nums.length; i++) {
            res[m++] = q.peekFirst();
            q.pollFirst();
            operateQ(nums, i, q);
        }
        res[m] = q.pollFirst();
        return res;
    }

    public void operateQ(int[] nums, int i, Deque<Integer> q) {
        int p = 0;
        while (!q.isEmpty()) {
            if (q.peekLast() < nums[i]) {
                q.pollLast();
                p++;
            } else {
                break;
            }
        }
        while (p > 0) {
            q.offer(nums[i]);
            p--;
        }
        q.offer(nums[i]);
    }

}
