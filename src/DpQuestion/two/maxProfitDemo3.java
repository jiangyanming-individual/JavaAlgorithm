package DpQuestion.two;

public class maxProfitDemo3 {

    /**
     * 买卖股票3：最多完成两笔交易
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][5];
        //无状态
        dp[0][0] = 0;
        //买入
        dp[0][1] = -prices[0];
        //卖出
        dp[0][2] = 0;
        //买入
        dp[0][3] = -prices[0];
        //卖出
        dp[0][4] = 0;

        for (int i = 1; i < prices.length; i++) {
            //买入
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            //卖出
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            //买入
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            //买入
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[prices.length - 1][4];
    }
}
