package DpQuestion.two;

public class maxProfitDemo {


    /**
     * 买股票
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        int low = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 0; i < prices.length; i++) {
            //求最低点
            low = Math.min(prices[i], low);
            //求最大的利润
            result = Math.max(result, prices[i] - low);
        }
        //贪心
        return result;
    }

    public int maxProfit2(int[] prices) {
        int[][] dp = new int[prices.length][2];
        //初始化dp；
        //持有股票，所得最大现金
        dp[0][0] = -prices[0];
        //不持有股票
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            //持有
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            //之前就卖出和今天卖出
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
        }
        //取不到dp.length:
        return Math.max(dp[prices.length-1][0], dp[prices.length-1][1]);
    }
}
