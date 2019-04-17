import java.util.*;


public class Leetcode_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0 || nums == null) return res;
        dfs(nums, res, 0);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, int index) {
        if (index == nums.length) {
            List<Integer> ans = new ArrayList<>();
            for (Integer o :
                    nums) {
                ans.add(o);
            }
            res.add(ans);
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = index; i<nums.length;i++){
            if (set.add(nums[i])) {
                swap(nums, i, index);
                dfs(nums, res, index + 1);
                swap(nums, i, index);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Leetcode_47 o = new Leetcode_47();
        int[] nums = new int[]{1,2,3,4};
        System.out.println(o.permuteUnique(nums));
    }
}
