public class Leetcode_154 {
    // binary Search
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int l = nums.length;
        for (int i = 1; i < l; i++) {
            if (nums[i] < nums[i - 1]) {
                return nums[i];
            }
        }
        return nums[0];
    }

}
