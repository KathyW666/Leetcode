import java.util.Arrays;

public class Leetcode_43 {
    // 大数相乘
    public String multiply(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0 || num1 == null || num2 == null)
            return null;
        if (num1 == "0" || num2 == "0") return "0";
        int m = num1.length(), n = num2.length();
        int[] res = new int[m+n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + res[i+j+1];
                res[i+j] += sum / 10;
                res[i+j+1] = sum % 10;
            }
        }
        String ans = "";
        boolean flag = false;
        for (int num : res) {
            if (num == 0 && !flag) continue;
            else {
                flag = true;
                ans += num;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Leetcode_43 o = new Leetcode_43();
        String num1 = "2";
        String num2 = "3";
        System.out.println(o.multiply(num1, num2));
    }
}
