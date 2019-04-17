public class Leetcode_402 {


    public String removeKdigits(String num, int k) {
        if (num.length() == 0 || num.length() == k)
            return "0";
        int remain = num.length() - k;
        char[] stack = new char[num.length()];
        int top = 0;
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (top > 0 && stack[top - 1] > c && k > 0) {
                --top;
                --k;
            }
            stack[top] = c;
            top++;
        }
        int id = 0;
        while (id < remain && stack[id] == '0')
            id++;
        return id == remain ? "0" : new String(stack, id, remain - id);
    }


}
