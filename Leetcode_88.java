import java.util.Arrays;

public class Leetcode_88 {
    /**
     * 居然被最基本的merge卡了，非常复杂的想法
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m + n - 1; i >= n; i--) nums1[i] = nums1[i - n];
        int i = n, j = 0, k = 0;
        while (true) {
            while (i >= m + n && j < n) nums1[k++] = nums2[j++];
            if (j >= n) break;
            if (nums1[i] <= nums2[j]) nums1[k++] = nums1[i++];
            else nums1[k++] = nums2[j++];
        }
    }

    // 原地，直接反过来比较
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 || j >= 0) {
            if (i < 0) nums1[k--] = nums2[j--];
            else if (j < 0) nums1[k--] = nums1[i--];
            else if (nums1[i] > nums2[j]) nums1[k--] = nums1[i--];
            else nums1[k--] = nums2[j--];
        }
    }


    public static void main(String[] args) {
        Leetcode_88 o = new Leetcode_88();
        int[] nums1 = new int[]{1, 2, 4, 5, 0, 0};
        int m = 5;
        int[] nums2 = new int[]{3};
        int n = 1;
        long startTime = System.nanoTime();
        o.merge(nums1, m, nums2, n);
        long endTime = System.nanoTime();
        System.out.println(Arrays.toString(nums1));
        System.out.println("Time: " + (endTime - startTime));

        nums1 = new int[]{1, 2, 4, 5, 6, 0};
        nums2 = new int[]{3};
        startTime = System.nanoTime();
        o.merge1(nums1, m, nums2, n);
        endTime = System.nanoTime();
        System.out.println(Arrays.toString(nums1));
        System.out.println("Time: " + (endTime - startTime));
    }
}
