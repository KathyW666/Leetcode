public class Leetcode_72 {
    /**
     * 编辑距离算法：DP （类似于字符串匹配/正则..）
     * 操作：1.删除 2.插入 3.改变
     * dp[i][j] =
     * min(dp[i-1][j], dp[i][j-1], word1[i] == word2[j] ? dp[i-1][j-1] : dp[i-1][j-1]+1)
     * @param word1
     * @param word2
     * @return 编辑后相等需要的步数
     */
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0 && word2.length() == 0) return 0;
        else if (word1.length() == 0) return word2.length();
        else if (word2.length() == 0) return word1.length();
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 1; j <= n; j++) dp[0][j] = j;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1);
                if (word1.charAt(j-1) == word2.charAt(i-1))
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]);
                else dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + 1);
            }
        }
        return dp[m][n];

    }
}
