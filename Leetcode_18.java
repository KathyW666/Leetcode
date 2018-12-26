import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// nums = [1, 0, -1, 0, -2, 2]
// sortednums = [-2, -1, 0, 0, 1, 2]
public class Leetcode_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < len - 3; i++) {
            for (int j = i + 1; j < len - 2; j++) {
                int k = j + 1;
                int l = len - 1;
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        while (k < l && nums[k] == nums[k+1]) ++k;
                        while (k < l && nums[l] == nums[k-1]) --l;
                        k++;l--;
                    }
                    else if (sum > target) --l;
                    else ++k;
                }
                while (j < len - 2 && nums[j] == nums[j+1]) ++j;
            }
            while (i < len - 2 && nums[i] == nums[i+1]) ++i;
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode_18 o = new Leetcode_18();
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        System.out.println(o.fourSum(nums,0));
    }
}
