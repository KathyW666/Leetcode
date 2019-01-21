import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Leetcode_90 {
    /**
     * AC 递归dfs，在dfs里判断list的元素是否重复，很复杂
     * 可以先将数组排序，然后直接跳过重复元素
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        if (nums.length == 0) return res;
        for (int i = 1; i <= nums.length; i++)
            dfs(res, new ArrayList<>(), nums, 0, i);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> ans, int[] nums, int id, int len) {
        List<Integer> com = new ArrayList(ans);
        com.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        if (ans.size() == len && !res.contains(com)) {
            res.add(new ArrayList<>(com));
            return;
        }
        for (int i = id; i < nums.length; i++) {
            ans.add(nums[i]);
            dfs(res, ans, nums, i+1, len);
            ans.remove(ans.size()-1);
        }
    }

    public List<List<Integer>> answer(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        helper(res, ans, 0, nums);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> ans, int id, int[] nums) {
        if (id <= nums.length) res.add(ans);
        int i = id;
        while (i < nums.length) {
            ans.add(nums[i]);
            helper(res, new ArrayList<Integer>(ans), i+1, nums);
            ans.remove(ans.size()-1);
            i++;
            while (i < nums.length && nums[i] == nums[i-1]) i++;
        }
    }



    public static void main(String[] args) {
        Leetcode_90 o = new Leetcode_90();
        int[] nums = new int[]{4,1,0,4,4,2,4,4,4};
        long start1 = System.nanoTime();
        System.out.println(o.subsetsWithDup(nums));
        long end1 = System.nanoTime();
        System.out.println(end1 - start1);
        long start2 = System.nanoTime();
        System.out.println(o.subsetsWithDup(nums));
        long end2 = System.nanoTime();
        System.out.println(end2 - start2);
    }
}
