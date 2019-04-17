import java.util.Arrays;

/**
 * 题目描述：leetcode-45 变形
 * 加油站问题
 */

public class Baidu {
    public int minGasStation(int numOfGS, int[] distOfFs,
                             int[] allowedGasoline, int distance,
                             int initalGasoline) {
        if (distance == 0) return 0;
        int[] nums = new int[distance+1];
        nums[0] = initalGasoline;
        for (int i = 0; i < distOfFs.length; i++) {
            nums[distOfFs[i]] = allowedGasoline[i];
        }
        System.out.println(Arrays.toString(nums));
        if (nums.length == 0 || nums == null) return 0;
        int jump = 0, last = 0, curr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > last) {
                if (curr <= last) return -1;
                else {
                    last = curr;
                    jump++;
                }
            }
            curr = Math.max(curr, i + nums[i]);
        }
        return jump-1;
    }

    public static void main(String[] args) {
        Baidu o = new Baidu();
        int numOfGS = 4;
        int[] distOfFs = new int[]{6,7,8,10};
        int[] allowedGasoline = new int[]{2,3,1,5};
        int distance = 15;
        int initalGasoline = 5;
        int res = o.minGasStation(numOfGS, distOfFs, allowedGasoline, distance, initalGasoline);
        System.out.println(res);
    }
}
