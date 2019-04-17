import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Leetcode_128 {
    /**
     * AC 排序 时间 O(nlogn)，空间和排序方法有关
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int res = 0, temp = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i+1] - nums[i] == 1) temp++;
            else if (nums[i+1] - nums[i] == 0) continue;
            else {
                res = temp > res ? temp : res;
                temp = 0;
            }
        }
        return Math.max(res, temp) + 1;
    }

    /**
     * HashMap
     * 时间 O(n), 空间 O(1)
     */
    public int hashSetMethod(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) numSet.add(num);
        int res = 0;
        for (int num : numSet) {
            if (!numSet.contains(num-1)) {
                int curr = num;
                int tempRes = 1;
                while (numSet.contains(num+1)) {
                    num++;
                    tempRes++;
                }
                res = Math.max(res, tempRes);
            }
        }
        return res;
    }
}
