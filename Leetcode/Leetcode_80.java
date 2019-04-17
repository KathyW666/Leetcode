public class Leetcode_80 {
    /**
     * 神答案，我肯定想不到用迭代器
     * [0,1,1,1,2,2,3] -> [0,1,1,2,2,3]
     */
    /**
     * public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }
     */

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }
}
