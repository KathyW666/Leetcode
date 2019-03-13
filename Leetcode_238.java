public class Leetcode_238 {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int mul = 1;
        int countZero = 0;
        for (int i : nums) {
            if (i == 0) countZero++;
            mul *= i;
        }
        int withoutZero = 1;
        if (countZero == 1) {
            for (int i : nums)
                if (i != 0) withoutZero *= i;
        }
        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) output[i] = mul / nums[i];
            else {
                if (countZero == 1) output[i] = withoutZero;
                else output[i] = 0;
            }
        }
        return output;
    }

}
