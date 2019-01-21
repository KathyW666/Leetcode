public class Leetcode_84 {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0 || heights == null) return 0;
        int len = heights.length;
        int lo = 0, hi = len - 1;
        int maxArea = len * findMin(heights, lo, hi);
        while (lo < hi) {
            if (heights[lo] <= heights[hi]) lo++;
            else hi--;
            int newArea = (hi - lo + 1) * findMin(heights, lo, hi);
            maxArea = newArea > maxArea ? newArea : maxArea;
        }
        return maxArea;
    }

    private int findMin(int[] heights, int lo, int hi) {
        int min = heights[lo];
        for (int i = lo; i <= hi; i++) min = heights[i] < min ? heights[i] : min;
        return min;
    }

    public static void main(String[] args) {
        Leetcode_84 o = new Leetcode_84();
        int[] heights = new int[]{0,0};
        System.out.println(o.largestRectangleArea(heights));
    }
}
