import java.util.ArrayList;
import java.util.Scanner;

public class Leetcode_9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        else if (x < 10) return true;
        else {
            ArrayList s = new ArrayList();
            while (x > 0) {
                s.add(x % 10);
                x = x / 10;
            }
            int len = s.size();
            for (int i = 0; i < len / 2; i++) {
                if (s.get(i) != s.get(len - 1 - i)) return false;
            }
            return true;
        }


    }
    public static void main(String[] args) {
        Leetcode_9 o = new Leetcode_9();
        while (true) {
            Scanner input = new Scanner(System.in);
            int in = input.nextInt();
            System.out.println(o.isPalindrome(in));
        }
    }

}
