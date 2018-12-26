import java.util.Scanner;
import java.util.Stack;

public class Leetcode_32 {

    /**
     * ************************************************************
     * Example 1:
     * Input: "(()"
     * Output: 2
     * Explanation: The longest valid parentheses substring is "()"
     * <p>
     * Example 2:
     * Input: ")()())"
     * Output: 4
     * Explanation: The longest valid parentheses substring is "()()"
     *
     * 知识点：堆栈，由于有（）（（）的情况，并非简单的元素个数相减
     * 因此栈中储存的是元素的id
     ***************************************************************/

    public int longestValidParentheses(String s) {
        int len = s.length(), res = 0;
        Stack st = new Stack();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') st.push(i);
            else {
                if (!st.isEmpty()) {
                    if (s.charAt((int)st.peek()) == '(') st.pop();
                    else st.push(i);
                }
                else st.push(i);
            }
        }
        if (st.isEmpty()) return len;
        else {
            int a = len, b = 0;
            while (!st.isEmpty()) {
                b = (int)st.peek();
                st.pop();
                res = Math.max(res, a-b-1);
                a = b;
            }
            res = Math.max(res, a);
        }
        return res;
    }


    public static void main(String[] args) {
        Leetcode_32 o = new Leetcode_32();
        while (true) {
            Scanner input = new Scanner(System.in);
            String in = input.next();
            System.out.println(o.longestValidParentheses(in));
        }
    }
}
