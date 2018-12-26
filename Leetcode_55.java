public class Leetcode_55 {
    /**
     * AC 贪心算法 时间O(n),空间O(1);
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 0 || nums == null) return false;
        int len = nums.length;
        if (len == 1) return true;
        if (nums[0] == 0) return false;
        for (int i = 1; i < len; i++) {
            nums[i] = Math.max(nums[i-1], i + nums[i]);
            if (nums[i] >= len - 1) return true;
            if (nums[i] <= i) return false;
        }
        return true;
    }
}
