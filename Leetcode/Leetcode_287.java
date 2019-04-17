public class Leetcode_287 {

    public int findDuplicate(int[] nums) {
        int p1 = nums[0], p2 = nums[0];
        do {
            p1 = nums[p1];
            p2 = nums[nums[p2]];
        } while (p1 != p2);
        int s1 = nums[0];
        int s2 = p1;
        while (s1 != s2) {
            s1 = nums[s1];
            s2 = nums[s2];
        }
        return s1;

    }
}
