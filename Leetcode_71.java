import java.util.Scanner;
import java.util.Stack;

public class Leetcode_71 {
    public String simplifyPath(String path) {
        if (path.length() == 0 || path == null) return "";
        String[] strings = path.split("/");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() == 0 || strings[i] == null || strings[i].equals("."))
                continue;
            else if (strings[i].equals("..")) {
                if (stack.size() > 0) stack.pop();
            }
            else stack.push(strings[i]);
        }
        // List<String> l = new ArrayList(stack); 直接创建stack
        String res = new String();
        while (stack.size() != 0) {
            res = "/" + stack.pop() + res;
        }
        if (res.length() == 0) return "/";
        return res;
    }

    public static void main(String[] args) {
        Leetcode_71 o71 = new Leetcode_71();
        Scanner input = new Scanner(System.in);
        String path = "/../";
        System.out.println(o71.simplifyPath(path));
    }
}
