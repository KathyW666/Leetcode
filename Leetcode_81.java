public class Leetcode_81 {
    //AC
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        int i = 1;
        while (i < nums.length) {
            if (nums[i] < nums[i-1]) break;
            i++;
        }
        return binarySearch(nums, 0, i-1, target) || binarySearch(nums, i, nums.length-1, target);
    }

    public boolean binarySearch(int[] nums, int lo, int hi, int target) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) lo = mid + 1;
            else if (nums[mid] > target) hi = mid - 1;
            else return true;
        }
        return false;
    }
}
