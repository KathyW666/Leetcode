public class Leetcode_279 {
        public int numSquares(int n) {
            if (n == 0) return 0;
            int[] dp = new int[n+1];
            dp[0] = 0;
            for (int i = 1; i <= n / 2; i++) {
                if (i*i > n) break;
                dp[i*i] = 1;
            }
            for (int i = 1; i <= n; i++) {
                if (dp[i] != 1) dp[i] =  i;
                int min = i;
                for (int j = 1; j <= i / 2; j++) {
                    min = (dp[j] + dp[i-j]) < min ? dp[j] + dp[i-j] : min;
                }
                dp[i] = Math.min(dp[i], min);
            }
            return dp[n];

        }

}
