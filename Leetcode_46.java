import java.util.ArrayList;
import java.util.List;

public class Leetcode_46 {
    // 无重复元素组合
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0 || nums == null) return res;
        dfs(nums, res, new ArrayList<Integer>());
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, ArrayList<Integer> ans) {
        if (ans.size() >= nums.length) {
            res.add(new ArrayList<>(ans));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (ans.size() == 0 || !ans.contains(nums[i])) {
                ans.add(nums[i]);
                dfs(nums, res, ans);
                ans.remove(ans.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Leetcode_46 o = new Leetcode_46();
        int[] nums = new int[]{1,2,3};
        System.out.println(o.permute(nums));
    }
}
