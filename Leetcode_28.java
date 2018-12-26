import java.util.Scanner;

public class Leetcode_28 {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
        if (!haystack.contains(needle)) return -1;

        int i = 0;
        int temp = 0;
        boolean flag = false;
        while (i < haystack.length()) {
            int j = 0;
            temp = i;
            while (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == needle.length()) {
                    flag = true;
                    break;
                }
            }
            if (flag) break;
            i = temp;
            i++;
        }
        return temp;
    }

    public static void main(String[] args) {
        Leetcode_28 o = new Leetcode_28();
        while (true) {
            Scanner in = new Scanner(System.in);
            String haystack = in.next();
            String needle = in.next();
            System.out.println(o.strStr(haystack, needle));
        }
    }
}
