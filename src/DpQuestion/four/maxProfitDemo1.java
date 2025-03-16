package DpQuestion.four;

public class maxProfitDemo1 {


    /**
     * 最佳买卖股票问题1：股票只会买卖一次
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // 定义dp
        int[][] dp=new int[prices.length][2];
        // dp[i][0] =不持有股票，dp[i][1]=表示持有股票

        // 初始化dp
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for (int i=1;i<prices.length;i++){
            // 递推公式：dp[i][0]=Max(dp[i-1][0], dp[i-1][1] + prices[i])
            // dp[i][1] =max(dp[i-1][1],prices[i]) 因为股票只会买卖一次；
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            dp[i][1]=Math.max(dp[i-1][1], - prices[i]);
        }

        // 返回两者之间的最大值：
        return Math.max(dp[prices.length-1][0],dp[prices.length-1][1]);
    }
}
