import java.util.Scanner;

/**
 * 题目描述：n的阶乘最后一个非0的数
 * 暴力就好
 */
public class Kuaishou2 {
    private int[] a = new int[] {1,2,4,3};
    private int[] b = new int[] {1,1,2,6,4};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Kuaishou2 o = new Kuaishou2();
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            int res = o.factorial(n);
            if (n <= 1) {
                System.out.println(n);
                continue;
            }
            if (res%2==1) res = (res+5)%10;
            System.out.println(res);
        }
    }

    public int factorial(int n) {
        if (n < 5) return b[n];
        int t = n % 5;
        int k = n / 5;
        return a[k%4]*factorial(t%5)*factorial(k)%5;
    }
}
