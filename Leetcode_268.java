public class Leetcode_268 {

    public int missingNumber(int[] nums) {
        int i = 0;
        int sum = 0;
        int sumM = nums.length * (nums.length + 1) / 2;
        while (i < nums.length) {
            sum += nums[i];
            i++;
        }
        return sumM - sum;
    }
}
