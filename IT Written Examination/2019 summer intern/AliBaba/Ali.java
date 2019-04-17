import java.util.Scanner;

/***
 * 题目描述：有M个红球和N个白球， 放到K个碗里，一个碗里只能放一种球，且碗没有顺序
 * 例如1个红球和1个白球，放入3个碗里只有{1, 0, 1} 一种情况
 * {1, 0, 1}，{1, 1, 0}，{0, 1, 1} 算一种
 * 返回可以方法个数

 * Input: 1, 1, 3
 * Output: 1;
 */

public class Ali {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int m = in.nextInt();
            int n = in.nextInt();
            int k = in.nextInt();
            System.out.println(helper(m, n, k));
        }


    }

    public static int helper(int m, int n, int k) {
        if (k == 1) return 0;
        if (k == 2) return 1;
        int limit = (m == n) ? k / 2 : k;
        int res = 0;
        for (int i = 1; i <= limit; i++) {
            res += calculate(m, i) * calculate(n, k - i);
        }
        return res;
    }

    public static int calculate(int M, int N) {
        int[][] dp = new int[M + 1][N + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= M; i++) {
            dp[i][1] = 1;
        }
        for (int i = 1; i <= N; i++) {
            dp[1][i] = 1;
        }
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (i >= j) dp[i][j] = dp[i][j - 1] + dp[i - j][j];
                else dp[i][j] = dp[i][j - 1];
            }
        }
        return dp[M][N];
    }
}
