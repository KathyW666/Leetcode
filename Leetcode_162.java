public class Leetcode_162 {
    /**
     * 寻找峰值 遍历 O(n) O(1); 二分 O(logn) O(1)
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > nums[mid+1]) hi = mid;
            else lo = mid+1;
        }
        return lo;
    }
}
