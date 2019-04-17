import java.util.Scanner;

/**
 * 题目描述：AC 字符串去重变形问题
 * Input: "AABBBCC"
 * AABBBCC -> AABBCC -> AABCC
 */

public class byte_2 {
    public static void main(String[] args) {
        byte_2 o = new byte_2();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            String s = input.next();
            System.out.println(o.modify(s));
        }
    }

    public String modify(String s) {
        if (s == null || s.length() == 0 || s.length() == 1 || s.length() == 2) return s;
        int firP = 0, secP = 0;
        for (int i = 0; i < s.length()-2; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                if (s.charAt(i+1) == s.charAt(i+2)) {
                    s = s.substring(0,i+2)+s.substring(i+3);
                    i--;
                }
                else if (i != s.length()-3 && s.charAt(i+3) == s.charAt(i+2)) {
                    s = s.substring(0,i+3)+s.substring(i+4);
                    i--;
                }
            }
        }
        return s;
    }

}
