package DpQuestion.two;

public class maxProfit4 {


    // 可以交易k次：
    public int maxProfit(int k, int[] prices) {

        if (prices.length == 0) return 0;
        int[][] dp = new int[prices.length][2 * k + 1];

        //初始化dp
        for (int j = 1; j <= 2 * k - 1; j += 2) {
            //奇数买入
            dp[0][j] = -prices[0];
        }
        //从1开始遍历，之前都初始化过了
        for (int i = 1; i < prices.length; i++) {
            //每次加2：
            for (int j = 0; j <= 2 * k - 2; j += 2) {

                //买入：当天买入或者前一天买入
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                //卖出股票： 当天卖出或者前一天卖出
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
            }
        }
        return dp[prices.length - 1][2 * k];
    }
}
