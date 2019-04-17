public class Leetcode_152 {
    public int bruteForce(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int max = nums[0];
        for (int i = 0; i < n; i++) {
            int tmp = nums[i];
            for (int j = i + 1; j < n; j++) {
                tmp = tmp * nums[j];
                if (tmp > max) max = tmp;
                else max = Math.max(max, nums[j]);
            }
        }
        return max;
    }

    /**
     * 动态规划 维护三个变量，保存<font size="3" color="red">以当前数字结尾</font>的子序列乘积最大值和最小值
     * @param nums
     * @return
     */
    public int dyPro(int[] nums) {
        if (nums.length == 0 || nums == null) return Integer.MIN_VALUE;
        int maxP = nums[0], minP = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = maxP;
            maxP = Math.max(nums[i], Math.max(maxP * nums[i], minP * nums[i]));
            minP = Math.min(nums[i], Math.min(minP * nums[i], tmp * nums[i]));
            if (maxP > res) res = maxP;
        }
        return res;
    }
}
