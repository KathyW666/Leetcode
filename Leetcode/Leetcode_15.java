import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 3 SUM 排序降低复杂度
 */
public class Leetcode_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Integer[] numArray = sortedArray(nums);

        for (int i = 0; i < len - 1; i++) {
            int j = i + 1;
            int k = len - 1;
            while (j < k) {
                int sum = numArray[i] + numArray[j] + numArray[k];
                if (sum == 0) {
                    List<Integer> add = Arrays.asList(numArray[i],numArray[j],numArray[k]);
                    if (!res.contains(add)) res.add(add);
                    k--;
                } else if (sum > 0) --k;
                else ++j;
            }
        }
        return res;
    }

    /** while (lo < hi && num[lo] == num[lo+1]) lo++;
        while (lo < hi && num[hi] == num[hi-1]) hi--;
        lo++; hi--;
        通过在数组中判断重复元素来避免重复元素
     */

//    private boolean binarySearch(Integer n, Integer[] nums, int j) {
//        if (nums[j] > n || nums[nums])
//        int lo = j, hi = nums.length - 1;
//        int id = -1;
//        while (lo < hi) {
//            int mid = (lo + hi) / 2;
//            if (n < nums[mid]) hi = mid;
//            else if (n > nums[mid]) lo = mid;
//            else break;
//        }
//    }

    private Integer[] sortedArray(int[] nums) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }

        Comparator cmp = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if ((int) o1 > (int) o2) return 1;
                if ((int) o1 < (int) o2) return -1;
                return 0;
            }
        };

        list.sort(cmp);
        Integer[] res = new Integer[nums.length];
        list.toArray(res);
        return res;
    }

    public static void main(String[] args) {
        Leetcode_15 o = new Leetcode_15();
        int[] num = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(o.threeSum(num));
    }
}
