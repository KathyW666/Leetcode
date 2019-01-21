public class Leetcode_122 {
    /**
     * 同121
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int n = prices.length;
        int profit = 0, valley = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            valley = prices[i] < valley ? prices[i] : valley;
            profit += prices[i] - valley > 0 ? prices[i] - valley : 0;
            valley = prices[i];
        }
        return profit;
    }

    /**
     * 更简单的语句
     * @param prices
     * @return
     */
    public int answer(int[] prices) {
        if (prices.length == 0) return 0;
        int n = prices.length;
        int profit = 0;
        for (int i = 1; i < n; i++) {
            int ADD = prices[i] - prices[i-1];
            profit += ADD > 0 ? ADD : 0;
        }
        return profit;
    }
}
