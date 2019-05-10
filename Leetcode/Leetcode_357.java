public class Leetcode_357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n < 0 || n > 10) return 0;
        if (n == 0) return 1;
        if (n == 1) return 10;
        if (n == 2) return 91;
        int[] dp = new int[n+1];
        dp[1] = 10;
        dp[2] = 81;
        int res = dp[1]+dp[2];
        for (int i = 3; i <= n; i++) {
            if (n > 10) break;
            dp[i] = dp[i-1] * (11 - i);
            res += dp[i];
        }
        return res;
    }
}
