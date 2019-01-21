import java.util.ArrayList;
import java.util.List;

/**
 * AC 回溯，类似题39（组合求和），46（全排列无重复元素），47（全排列有重复元素）
 */
public class Leetcode_77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int[] a = new int[n];
        for (int i = 1; i <= n; i++) a[i-1] = i;
        dfs(res, new ArrayList<Integer>(), 0, a, k);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> ans, int id, int[] a, int k) {
        if (ans.size() >= k) {
            res.add(new ArrayList<Integer>(ans));
            return;
        }
        for (int i = id; i < a.length; i++){
            ans.add(a[i]);
            dfs(res, ans, i+1, a, k);
            ans.remove(ans.size()-1);
        }
    }
}
