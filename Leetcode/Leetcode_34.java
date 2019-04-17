import java.util.Arrays;

public class Leetcode_34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums.length == 0 || nums == null) return res;
        int id = binarySearch(nums, target);
        if (id == -1) return res;
        else {
            res[0] = id; res[1] = id;
            while(res[1] < nums.length && nums[res[1]] == target) res[1]++;
            while(res[0] >= 0 && nums[res[0]] == target) res[0]--;
            res[1]--;
            res[0]++;
            return res;
        }

    }

    public int binarySearch(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target < nums[mid]) hi = mid - 1;
            else if (target > nums[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        Leetcode_34 o = new Leetcode_34();
        int[] nums = new int[]{1};
        System.out.println(Arrays.toString(o.searchRange(nums, 1)));
    }
}
