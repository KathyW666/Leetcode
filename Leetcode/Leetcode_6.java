import java.util.Scanner;

public class Leetcode_6 {
    public String convert(String s, int numRows) {
        if (numRows < 1) return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder("");
        }

        int incre = 1;
        int id = 0;
        for (int i = 0; i < s.length(); i++) {
            sb[id] = sb[id].append(s.charAt(i));
            if (id == 0) incre = 1;
            if (id == numRows - 1) incre = -1;
            id += incre;
        }
        String res = "";
        for (int i  = 0; i < sb.length; i++)
            res += sb[i].toString();

        return res;
    }

    public static void main(String[] args) {
        Leetcode_6 o = new Leetcode_6();
        while (true) {
            Scanner input = new Scanner(System.in);
            String in = input.next();
            int num = input.nextInt();
            System.out.println(o.convert(in, num));
        }

    }
}
