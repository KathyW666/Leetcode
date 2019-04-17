import java.util.Scanner;

/**
 * 题目描述：leetcode-72 编辑距离算法 原题
 */
public class Kuaishou {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Kuaishou o = new Kuaishou();
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String s1 = in.next();
            String s2 = in.next();
            System.out.println(o.diff(s1,s2));
        }
    }

    public int diff(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        int[][] dp = new int[l2+1][l1+1];
        dp[0][0] = 0;
        for (int i = 1 ; i <= l1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1 ; i <= l2; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= l2; i++) {
            for (int j = 1; j <= l1; j++) {
                int curr = 0;
                if (s1.charAt(j-1) == s2.charAt(i-1)) {
                    curr = dp[i-1][j-1];
                } else {
                    curr = dp[i-1][j-1]+1;
                }
                dp[i][j] = Math.min(Math.min(dp[i-1][j]+1, dp[i][j-1]+1), curr);
            }
        }
        return dp[l2][l1];
    }
}
