import java.util.HashMap;
import java.util.Map;

public class Leetcode_136 {
    /**
     * AC 找到唯一的一个单蹦的数
     * 法1：HashMap O(n), O(n)
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) map.put(nums[i], 1);
            else map.put(nums[i], map.get(nums[i]) + 1);
        }
        while (!map.isEmpty()) {
            for (Integer i : map.keySet()) {
                if (map.get(i) == 1) return i;
            }
        }
        return nums[0];
    }

    /**
     * ！异或
     */
    public int ansXOR(int[] nums) {
        int x = 0;
        for (int n : nums) x = x ^ n;
        return x;
    }
}
