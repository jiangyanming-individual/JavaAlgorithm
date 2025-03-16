package DpQuestion.three;

public class maxProfitDemo2 {


    /**
     * 1.买卖股票的最佳时机：
     * 2. [0][0]: 表示未持有股票
     *    [0][1]: 表示持有股票
     * 3. 卖出股票： dp[i][0]=Max(dp[i-1][0],dp[i-1][1] + prices[i]);
     *    买入股票： dp[i][1]=max(dp[i-1][1],dp[i-1][0] -prices[i]);
     * 4. 取最大的值
     *
     * 5. 和121 买卖股票唯一不同的是， 本题的股票可以买卖多次
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // 定义 dp, dp[i][0]:表示没有持有股票，dp[i][1]:表示持有股票
        int [][] dp=new int[prices.length][2];
        // 初始化：
        dp[0][0]=0;
        dp[0][1]= -prices[0];
        // 遍历数组：
        for (int i=1;i<prices.length;i++){

            // 前一天不持有股票和 前一天持有，今天卖出股票
            dp[i][0]=Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            // 前一个持有和 前一天不持有今天买入
            dp[i][1] =Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }

        // 返回两者的差值:
        return Math.max(dp[prices.length-1][0],dp[prices.length-1][1]);
    }
}
