import java.util.Scanner;

/**
 * 题目描述：判断整数n的因数有多少个
 * 可以暴力，或者开跟号n，进行优化
 * 但是没有通过所有的case
 */

public class Duxiaoman {
    public static void main(String[] args) {
        Duxiaoman o = new Duxiaoman();
        Scanner input = new Scanner(System.in);
        while (true) {
            long n = input.nextInt();
            long m = input.nextInt();
            System.out.println(o.countONU(n, m));
        }
    }

    public int countONU(long n, long m) {
        int sq = (int) Math.sqrt(n);
        int count = 0;
        for (int i = 1; i <= sq; i++) {
            if (n % i == 0) {
                if (i >= m) {
                    if (i*i == n) count++;
                    else count += 2;
                }
                else {
                    if (n / i >= m) count++;
                }
            }
        }
        return count;
    }
}
