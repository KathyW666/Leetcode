import java.util.Scanner;

/**
 * 题目描述：给两个数3,11
 * 只能对第一个数进行+1，-1，*2操作
 * 返回最少操作的次数
 * 3*2*2-1 返回 3
 */

public class Kuaishou_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Kuaishou_3 o = new Kuaishou_3();
        while (in.hasNext()) {
            int x = in.nextInt();
            int y = in.nextInt();
            System.out.println(o.operate(x, y));
        }
    }

    private int operate(int x, int y) {
        if (x == y) return 0;
        if (x < 0 && y < 0) return solve(-x, -y);
        if (x < 0) return -x + solve(0, y);
        if (y < 0) return x + solve(0, -y);
        return solve(x, y);

    }

    private int solve(int x, int y) {
        if (x >= y) return x - y;
        else {

            return 1;

        }
    }
}
