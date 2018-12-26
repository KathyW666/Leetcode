import java.util.Scanner;

/**
 * DP思想 https://www.jianshu.com/p/b591b74008d0
 */
public class Leetcode_10 {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0 && s.length() == 0) return true;
        if (s == null || p == null || p.length() == 0) return false;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        // 初始化，标记a*/a***...为true
        if (p.charAt(0) == '*') return false;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1])
                dp[0][i + 1] = true;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i))
                    dp[i+1][j+1] = dp[i][j];
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i)
                            && p.charAt(j-1) != '.')
                        dp[i+1][j+1] = dp[i+1][j-1];
                    else dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                }
            }
        }
        return dp[s.length()][p.length()];
    }


    public static void main(String[] args) {
        Leetcode_10 o = new Leetcode_10();
        while (true) {
            Scanner input = new Scanner(System.in);
            String s = input.next();
            System.out.println(o.isMatch("", s));
        }
    }
}
