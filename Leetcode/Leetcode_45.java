import java.util.Arrays;

public class Leetcode_45 {
    /**
     * 贪心算法 复杂度O(n)
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int jump = 0, last = 0, curr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > last) {
                last = curr;
                jump++;
            }
            curr = Math.max(curr, i + nums[i]);
        }
        return jump;
    }

    public static void main(String[] args) {
        Leetcode_45 o = new Leetcode_45();
        int[] nums = new int[]{5,9,3,2,1,0,2,3,3,1,0,0};
        System.out.println(o.jump(nums));
    }
}
