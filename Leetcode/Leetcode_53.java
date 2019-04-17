public class Leetcode_53 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int dp = nums[0];
        int max = dp;
        for (int i = 1; i < n; i++) {
            dp = nums[i] + (dp > 0 ? dp : 0);
            max = Math.max(max, dp);
        }
        return max;
    }
}
