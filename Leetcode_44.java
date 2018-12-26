public class Leetcode_44 {
    // 动态规划方法
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        if (m == 0 && n == 0) return true;
        else if (m == 0) return false;
        boolean dp[][] = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int a = 0; a < m && p.charAt(a) == '*'; a++) dp[0][a+1] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
                    dp[i + 1][j + 1] = dp[i][j];
                else if (p.charAt(j) == '*')
                    dp[i + 1][j + 1] = dp[i][j] || dp[i + 1][j] || dp[i][j + 1];
            }
        }
        return dp[n][m];
    }

    // 双指针方法
    public boolean isMatch1(String s, String p) {
        int n = s.length(), m = p.length();
        if (m == 0 && n == 0) return true;
        else if (m == 0) return false;
        int i = 0, j = 0, ri = -1, rj = -1;
        while (i < n) {
            if (p.charAt(j) == '*' && j < m) {
                ri = i;
                rj = j++;
            }
            else if (j < m && p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)) {
                i++;
                j++;
            }
            else if (rj > -1) {
                i = ++ri;
                j = rj + 1;
            }
            else return false;
        }
        while (j < m && p.charAt(j) == '*') j++;
        return j == m;
    }

    public static void main(String[] args) {
        Leetcode_44 o = new Leetcode_44();
        String s = "adceb", p = "*a*b";
        System.out.println(o.isMatch(s, p));
    }
}
