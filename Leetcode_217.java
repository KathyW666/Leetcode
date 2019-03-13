import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Leetcode_217 {
    /**
     * AC 检查数组中有无重复元素
     * 法1：Hashset O(n) O(n)
     * 法2: 排序 O(nlogn) O(n/1)
     * @param nums
     * @return
     */
    public boolean method1(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return false;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) return true;
        }
        return false;
    }

    public boolean method2(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return false;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) return true;
        }
        return false;
    }
}
