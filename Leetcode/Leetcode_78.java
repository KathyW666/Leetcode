import java.util.ArrayList;
import java.util.List;

public class Leetcode_78 {
    /**
     * AC 回溯,77变体。类似题39（组合求和），46（全排列无重复元素），47（全排列有重复元素）
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i <= nums.length; i++)
            dfs(res, new ArrayList<Integer>(), nums, 0, i);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> ans, int[] nums, int id, int k) {
        if (ans.size() >= k) {
            res.add(new ArrayList<Integer>(ans));
            return;
        }
        for (int i = id; i < nums.length; i++) {
            ans.add(nums[i]);
            dfs(res, ans, nums, i + 1, k);
            ans.remove(ans.size() - 1);
        }
    }

    // 厉害的写法，两个迭代
//  List<List<Integer>> result = new ArrayList<>();
//  result.add(new ArrayList<>());
//  for(int n : nums){
//      int size = result.size();
//      for(int i=0; i<size; i++){
//          List<Integer> subset = new ArrayList<>(result.get(i));
//          subset.add(n);
//          result.add(subset);
//      }
//  }
//  return result;
}