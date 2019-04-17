import java.util.Scanner;

public class Tencent2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            String str = in.next();
            char[] nums = str.toCharArray();
            int k = 0;
            while (helper(nums, nums.length - k) == true) {
                k += 2;
            }
            if (k % 4 == 0) {
                System.out.println("Oh,no.");
            } else {
                System.out.println("Yes,you can win!");
            }
        }
    }

    public static boolean helper(char[] nums, int len) {
        boolean flag = false;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] == nums[i+1]) {
                while(i < len - 2) {
                    nums[i] = nums[i+2];
                    i++;
                }
                flag = true;
                break;
            }
        }
        return flag;
    }
}
