import java.util.Scanner;

public class Leetcode_5 {
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        String sub = s.charAt(0) + "";
        int len = s.length();
        int subLen = 1;
        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j > i; j--) {
                if (s.charAt(i) == s.charAt(j) && (j - i + 1) > subLen && isPalindrome(s.substring(i, j + 1))) {
                    sub = s.substring(i, j + 1);
                    subLen = sub.length();
                }
            }
            if (len - i <= subLen) break;
        }
        return sub;
    }

    public boolean isPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcode_5 a = new Leetcode_5();
        while (true) {
            Scanner input = new Scanner(System.in);
            String in = input.next();
            System.out.println(a.longestPalindrome(in));
        }
    }
}
