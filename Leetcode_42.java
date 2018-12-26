public class Leetcode_42 {
    /**
     * AC 解
     * 左右一组解超时，暂且认为对于小数据集可用
     *
     * @param height
     * @return res: the total water
     */
    public int trap(int[] height) {
        if (height.length == 0 || height.length == 1 || height == null) return 0;
        int i = 0, j = height.length - 1, res = 0;
        while (i < height.length && height[i] == 0) i++;
        while (j >= 0 && height[j] == 0) j--;
        if (i >= j) return res;
        for (int k = i; k <= j; k++) {
            if (height[k] == 0) res++;
            else height[k]--;
        }
        res += trap(height);
        return res;
    }

    /**
     * 1，暴力算法
     * 时间O(n^2),空间O(1)
     *
     * @param height
     */
    public int trap1(int[] height) {
        if (height.length == 0 || height.length == 1 || height == null) return 0;
        int res = 0;
        int len = height.length;
        for (int i = 1; i < len - 1; i++) {
            int maxLeft = 0, maxRight = 0;
            for (int j = i; j >= 0; j--)
                maxLeft = Math.max(maxLeft, height[j]);
            for (int j = i; j < len; j++)
                maxRight = Math.max(maxRight, height[j]);
            res += Math.min(maxLeft, maxRight) - height[i];
        }
        return res;
    }

    /**
     * 2，动态规划
     * 时间3*O(n),空间O(n),空间换时间
     *
     * @param height
     */
    public int trap2(int[] height) {
        if (height.length == 0 || height.length == 1 || height == null) return 0;
        int res = 0;
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        leftMax[0] = height[0];
        rightMax[len - 1] = height[len - 1];
        for (int i = 1; i < len; i++)
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        for (int i = len - 2; i >= 0; i--)
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        for (int i = 1; i < len - 1; i++)
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        return res;
    }

    /**
     * 双指针
     * 时间O(n),空间O(1)
     *
     * @param height
     */
    public int trap3(int[] height) {
        if (height.length == 0 || height.length == 1 || height == null) return 0;
        int left = 0, right = height.length - 1;
        int res = 0;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) leftMax = height[left];
                else res += leftMax - height[left];
                ++left;
            }
            else {
                if (height[right] >= rightMax) rightMax = height[right];
                else res += rightMax - height[right];
                --right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode_42 o = new Leetcode_42();
        int[] height = new int[]{2, 0, 2};
        System.out.println(o.trap(height));
    }
}
