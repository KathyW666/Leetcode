import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0 || candidates == null) return null;
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        canForm(res, new ArrayList<Integer>(), candidates,  0, target);
        return res;
    }

    public void canForm(List<List<Integer>> res, List<Integer> ans, int[] candidates, int start, int target) {
        if (target > 0){
            for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
                ans.add(candidates[i]);
                canForm(res, ans, candidates, i,target - candidates[i]);
                ans.remove(ans.size()-1);
            }
        }
        else if (target == 0) res.add(new ArrayList<>(ans));
    }

    public static void main(String[] args) {
        Leetcode_39 o = new Leetcode_39();
        int[] candidates = new int[]{8,7,4,3};
                           System.out.println(o.combinationSum(candidates, 11));

    }
}
