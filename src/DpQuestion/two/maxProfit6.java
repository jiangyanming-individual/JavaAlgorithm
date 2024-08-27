package DpQuestion.two;

public class maxProfit6 {

    /**
     * 最佳时机含有手续费
     *
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {

        if (prices.length == 0) return 0;
        int[][] dp = new int[prices.length][2];

        //持有股票：
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //持有股票
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            //不持有股票
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }
        return dp[prices.length - 1][1];
    }
}
