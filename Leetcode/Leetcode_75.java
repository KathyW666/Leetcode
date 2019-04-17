public class Leetcode_75 {
    public void sortColors(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, i = lo + 1, gt = hi;
        int v = nums[lo];
        while (i <= gt) {
            if (nums[i] < v) exch(nums, lt++, i++);
            else if (nums[i] > v) exch(nums, i, gt--);
            else i++;
        }
        sort(nums, lo, lt - 1);
        sort(nums, gt + 1, hi);
    }

    public void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
