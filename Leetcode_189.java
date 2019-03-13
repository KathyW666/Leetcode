public class Leetcode_189 {
    /**
     * AC 额外空间 O(n), O(n)
     * @param nums
     * @param k
     */
    public void method1(int[] nums, int k) {
        if(nums.length == 0 || nums.length == 1 || k == 0) return;
        if (k > nums.length) k -= nums.length;
        int[] before = new int[nums.length - k];
        int[] after = new int[k];
        for (int i = 0; i < nums.length - k; i++)
            before[i] = nums[i];
        for (int i = nums.length - k, j = 0; i < nums.length; i++)
            after[j++] = nums[i];
        int id = 0;
        for (int i = 0; i < k; i++)
            nums[id++] = after[i];
        for (int i = 0; i < nums.length - k; i++)
            nums[id++] = before[i];
    }

    /**
     * AC 暴力 O(kn), O(1)
     * @param nums
     * @param k
     */
    public void method2(int[] nums, int k) {
        if(nums.length == 0 || nums.length == 1 || k == 0) return;
        if (k > nums.length) k -= nums.length;
        while (k > 0) {
            int tmp = nums[nums.length-1];
            for (int i = nums.length - 1; i > 0; i--)
                nums[i] = nums[i-1];
            nums[0] = tmp;
            k--;
        }
    }

    /**
     * 三次reverse O(n), O(1)
     * @param nums
     * @param k
     */
    public void method3(int[] nums, int k) {
        if(nums.length == 0 || nums.length == 1 || k == 0) return;
        if (k > nums.length) k -= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);

    }

    private void reverse(int[] a, int s, int e) {
        while (s < e) {
            int tmp = a[s];
            a[s] = a[e];
            a[e] = tmp;
            s++;
            e--;
        }
    }
}
