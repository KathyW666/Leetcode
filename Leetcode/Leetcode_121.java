public class Leetcode_121 {
    /**
     * AC 暴力 时间 O(n^2)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int n = prices.length;
        int profit = 0;
        for (int i = n - 1; i >= 0; i--)
            for (int j = 0; j <= i; j++)
                profit = prices[i] - prices[j] > profit ? prices[i] - prices[j] : profit;
        return profit;
    }

    /**
     * One-Pass 时间 O(n)
     * 寻找峰值和谷值
     * @param prices
     * @return
     */
    public int answer(int[] prices) {
        if (prices.length == 0) return 0;
        int n = prices.length;
        int profit = 0, valley = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            valley = prices[i] < valley ? prices[i] : valley;
            profit = prices[i] - valley > profit ? prices[i] - valley : profit;
        }
        return profit;
    }
}
