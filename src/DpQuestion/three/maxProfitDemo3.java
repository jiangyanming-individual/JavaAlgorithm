package DpQuestion.three;

public class maxProfitDemo3 {


    /**
     * 买卖股票3： 完成买卖2枝股票
     *
     * 1. 这时有四种股票的状态(1) 什么都不 (2) 买入 (3) 卖出 (4) 买入 (5) 卖出
     * 2. dp[i][j] 的状态都是由上面的一步推理过来的。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        // 定义dp
        int[][] dp=new int[prices.length][5];
        //什么都不操作
        dp[0][0]=0;
        // 买入
        dp[0][1]=-prices[0];
        //卖出
        dp[0][2]=0;
        //第二枝股票买入
        dp[0][3]=-prices[0];
        // 卖出
        dp[0][4]=0;
        // 遍历
        for (int i=1;i<prices.length;i++){
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            dp[i][2]=Math.max(dp[i-1][2],dp[i-1][1] + prices[i]);
            dp[i][3]=Math.max(dp[i-1][3],dp[i-1][2] -prices[i]);
            dp[i][4]=Math.max(dp[i-1][4],dp[i-1][3] + prices[i]);
        }
        return Math.max(dp[prices.length-1][1],Math.max(dp[prices.length-1][2],Math.max(dp[prices.length-1][3],dp[prices.length-1][4])));
    }

}
