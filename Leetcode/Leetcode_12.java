import java.util.Scanner;

public class Leetcode_12 {

    public String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }

    public static void main(String[] args) {
        Leetcode_12 o = new Leetcode_12();
        while (true) {
            Scanner input = new Scanner(System.in);
            int num = input.nextInt();
            System.out.println(o.intToRoman(num));
        }
    }
}
