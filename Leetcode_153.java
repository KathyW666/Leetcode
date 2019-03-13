public class Leetcode_153 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        // // O(n) O(1)
        // for (int i = 1; i < nums.length; i++) {
        //     if (nums[i] < nums[i-1]) return nums[i];
        // }
        // return nums[0];
        int lo = 0, hi = nums.length - 1;
        if (nums[hi] > nums[0]) return nums[0];
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if (nums[mid] < nums[mid - 1]) return nums[mid];
            if (nums[mid] > nums[0]) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

}
