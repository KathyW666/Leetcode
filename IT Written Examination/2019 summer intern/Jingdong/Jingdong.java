import java.util.Scanner;

/**
 * 题目描述：给定一个数组[1,0,2,0,3]
 * 0 出现的位置为丢失数的位置
 * 数组规则满足：
 * 1. a[0] <= a[1]
 * 2. a[n] <= a[n-1] (n >= 3)
 * 3. a[n] <= max(a[n-1], a[n+1])
 * 返回可能出现的数组个数
 */
public class Jingdong {
    private int count = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Jingdong o = new Jingdong();
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            o.helper(nums, 0);
            System.out.println(o.count);
        }
    }

    private void helper(int[] nums, int id) {
        if (nums[1] != 0 && nums[1] < nums[0]) return;
        if (id != 0 && id != nums.length - 1 && nums[id] >
                Math.max(nums[id - 1], nums[id + 1])) return;
        if (id >= nums.length - 1) {
            count++;
            return;
        }
        for (int i = id; i < nums.length; i++) {
            // 没考虑nums[0],nums[len-1] = 0
            if (nums[i] == 0) {
                int num = nums[i - 1];
                while (num >= 1) {
                    nums[i] = num;
                    helper(nums, i + 1);
                    nums[i] = 0;
                    num--;
                }
            }
        }
    }
}
