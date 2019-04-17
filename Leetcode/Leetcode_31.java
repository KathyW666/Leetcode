import java.util.Arrays;

public class Leetcode_31 {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (nums == null || len == 0 || len == 1) return;
        if (len == 2) {
            swap(nums, 0, 1);
            return;
        }
        if (nums[len - 1] > nums[len - 2]) {
            swap(nums, len - 1, len - 2);
            return;
        } else {
            int i = 3;
            while (i <= len && nums[len - i] >= nums[len - i + 1]) {
                ++i;
            }
            if (i > len) {
                Arrays.sort(nums);
                return;
            }
            int id = len - 1;
            while (nums[id] <= nums[len - i]) {
                id--;
            }
            swap(nums, len - i, id);
            Arrays.sort(nums,len-i+1,len);
            return;
        }

    }

    public void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Leetcode_31 o = new Leetcode_31();
        int[] nums = new int[]{4,2,4,4,3};
        o.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
