import java.util.Arrays;

public class Leetcode_66 {
    public int[] plusOne(int[] digits) {
        int count = digits.length;
        int[] res = new int[count+1];
        res[0] = 1;
        int i = 0;
        for (i = count - 1; i >=0; i--) {
            if (digits[i] == 9) digits[i] = 0;
            else break;
            count--;
        }
        if (count == 0) {
            for(int k = 1; k <= digits.length; k++) {
                res[k] = 0;
            }
            return res;
        }
        digits[i]++;
        return digits;
    }

    public static void main(String[] args) {
        Leetcode_66 o = new Leetcode_66();
        int[] d = new int[]{9};
        System.out.println(Arrays.toString(o.plusOne(d)));
    }
}
