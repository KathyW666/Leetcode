import java.util.HashSet;
import java.util.Set;

// AC Easy
public class Leetcode_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove(nums[i-1-k]);
            if (!set.add(nums[i])) return true;
        }
        return false;
    }
}
