public class Leetcode_300 {
    /**
     * 乱序数组，最长增序序列
     */
    class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int len = nums.length;
            int[] dp = new int[len];
            for (int i = 0; i < len; i++) {
                dp[i] = 1;
            }
            int max = 1;
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = dp[i] > dp[j] + 1 ? dp[i] : dp[j] + 1;
                    }
                    max = dp[i] > max ? dp[i] : max;
                }
            }
            return max;
        }
    }
}
