import java.util.Scanner;

/**
 * 题目描述：leetcode-135 分糖问题变形
 * leetcode 135 没有循环， 此题数组循环
 * 即a[0] 与 a[a.length-1] 也要比较
 * 思路：正向过一遍，反向过一遍，判断大的加和
 */
public class byte_3 {
    public static void main(String[] args) {
        byte_3 o = new byte_3();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            int len = input.nextInt();
            int[] nums = new int[len];
            for (int j = 0; j < len; j++) {
                nums[j] = input.nextInt();
            }
            System.out.println(o.sumPriceNum(nums));
        }
    }

    public int sumPriceNum(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[start] > nums[i]) start = i;
        }
        int[] rotatedNums = rotate(nums, start);
        return gifts(rotatedNums);
    }

    public int[] rotate(int[] nums, int start) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[(n - start + i) % n];
        }
        return ans;
    }

    public int gifts(int[] nums) {
        int[] rate = new int[nums.length];
        for (int i : rate) i = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) nums[i] = nums[i - 1] + 1;
        }
        if (nums[nums.length - 1] > nums[0]) nums[nums.length - 1] = 2;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                if (nums[i] == 1) nums[i] = nums[i + 1] + 1;
                else
                    nums[i] = Math.max(nums[i], nums[i + 1] + 1);
            }
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];
        return sum;

    }
}
