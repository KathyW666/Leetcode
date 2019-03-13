import java.util.Stack;

public class Leetcode_84 {
    /**
     * X 递增堆栈 heights[s.peek()] 指针替代，
     * 最后增加heights[len]=0解决数组中的0元素
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0 || heights == null) return 0;
        int len = heights.length;
        if (len == 1) return heights[0];
        Stack<Integer> increStack = new Stack<>();
        int res = 0;
        for (int i = 0; i <= len; i++) {
            int h = (i == len) ? 0 : heights[i];
            if (increStack.isEmpty() || h >= heights[increStack.peek()])
                increStack.push(i);
            else {
                int tp = increStack.pop();
                int width = increStack.isEmpty() ? i : i - increStack.peek() - 1;
                res = Math.max(res, heights[tp]*width);
                i--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode_84 o = new Leetcode_84();
        int[] heights = new int[]{1};
        System.out.println(o.largestRectangleArea(heights));
    }
}
