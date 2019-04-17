import java.util.Stack;

public class Leetcode_150 {
    /**
     * AC RPN 反向波兰表示法 - 栈的使用
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (stack.size() < 2) {
                stack.push(Integer.valueOf(tokens[i]));
                continue;
            }
            Integer o1 = stack.pop(), o2 = stack.pop();
            if (tokens[i].equals("+")) stack.push(o2 + o1);
            else if (tokens[i].equals("-")) stack.push(o2 - o1);
            else if (tokens[i].equals("*")) stack.push(o2 * o1);
            else if (tokens[i].equals("/")) stack.push(o2 / o1);
            else {
                stack.push(o2);
                stack.push(o1);
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }

    // 不明白的一点是为啥leetcode上不通过异常处理的代码
    // 用try - catch的话，几个例子能跑的通
    public int myevalRPN(String[] tokens) {
        if (tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            try {
                Integer n = Integer.valueOf(tokens[i]);
                stack.push(n);
            } catch (NumberFormatException e) {
                Integer o1 = stack.pop(), o2 = stack.pop();
                if (tokens[i] == "+") stack.push(o2 + o1);
                if (tokens[i] == "-") stack.push(o2 - o1);
                if (tokens[i] == "*") stack.push(o2 * o1);
                if (tokens[i] == "/") stack.push(o2 / o1);
            }
        }
        return stack.pop();
    }


}
