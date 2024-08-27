package DpQuestion.two;

public class maxProfit5 {


    /**
     * 股票含有冷冻期：
     *
     * @param prices
     * @return
     */

    public int maxProfit(int[] prices) {

        if (prices.length == 0) return 0;
        // 定义四种状态：0:持有股票， 1： 一直保持卖出股票的状态，2：今天卖出股票，3，今天冷冻期：
        int[][] dp = new int[prices.length][4];
        // 初始化
        dp[0][0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            //持有股票；前天冷冻期，今天买。 前天是保持卖出的状态，今天买入。 还有一直是持有的状态
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1] - prices[i], dp[i - 1][3] - prices[i]));
            //保持卖出股票的状态
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            //今天卖出股票
            dp[i][2] = dp[i - 1][0] + prices[i];
            //在冷冻期
            dp[i][3] = dp[i - 1][2];
        }
        return Math.max(dp[prices.length - 1][3], Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]));
    }
}
