public class Leetcode_11 {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int bound = (height[i] < height[j]) ? height[i++] : height[j--];
            int temp = (j - i + 1) * bound;
            max = Math.max(max, temp);
        }
        return max;
    }

    public static void main(String[] args) {
        Leetcode_11 o = new Leetcode_11();
        int[] in = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(o.maxArea(in));
    }


}
