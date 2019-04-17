import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * AC O(nlogn) 数组排序，找最大相邻两数差值
 */
public class Leetcode_164 {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        radixSort(nums);
        System.out.println(Arrays.toString(nums));
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            res = (nums[i] - nums[i-1]) > res ? (nums[i] - nums[i-1]) : res;
        }
        return res;
    }

    /**
     * 桶排序：时间复杂度，设有n个d位数，每位数有k种（如0~6，有7种可能，k为7）可能
     * 每个关键字时间复杂度为(n+k)，在分配完后，将各自的桶组在一起，共有k中取值。
     * 总的时间复杂度为O(d*(k+n))
     */
    public int[] radixSort(int[] nums) {
        if (nums == null) return nums;
        int[] dupNum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dupNum[i] = nums[i];
        }
        List<Integer>[] bucket = (List<Integer>[]) new List[10];
        for (int i = 0; i < 10; i++) {
            bucket[i] = new LinkedList<>();
        }
        while (true) {
            for (int i = 0; i < nums.length; i++) {
                bucket[dupNum[i] % 10].add(nums[i]);
            }
            int k = 0, sum = 0;
            for (int i = 0; i < 10; i++) {
                while (!bucket[i].isEmpty()) {
                    nums[k] = bucket[i].remove(0);
                    dupNum[k] = nums[k] / 10;
                    sum += dupNum[k];
                    k++;
                }
            }
            if(sum == 0) break;
        }
        return nums;
    }

    public static void main(String[] args) {
        Leetcode_164 o = new Leetcode_164();
        int[] nums = new int[]{21, 13, 26, 94, 41};
        o.maximumGap(nums);

    }
}
