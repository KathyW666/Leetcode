import java.util.*;

public class test {
    public static void main(String[] args) {
        String s = "/a/../../b/../c//.//";
        String[] strings = s.split("/");
        System.out.println(Arrays.asList(s.split("/")));
        Stack stack = new Stack();
        stack.push('d');
        stack.push('1');
        stack.push('2');
        stack.push('v');
        System.out.println(stack.peek());
        System.out.println();
}
}
