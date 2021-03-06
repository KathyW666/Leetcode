public class Leetcode_96 {
    /**
     * AC 求BST个数 DP 时间 O(n^2) 空间 O(n)
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
            for (int j = 0; j < i; j++)
                dp[i] += dp[j] * dp[i-j-1];
        return dp[n];
    }

    /**
     * 降维度打击：卡特兰数
     */

    public int answer(int n) {
        // Note: we should use long here instead of int, otherwise overflow
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }
}
