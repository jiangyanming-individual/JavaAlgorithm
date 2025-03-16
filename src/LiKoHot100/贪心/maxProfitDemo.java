package LiKoHot100.贪心;

import java.util.Map;

public class maxProfitDemo {


    /**
     * 买卖股票的最佳时机： 使用动态规划的思想或者使用贪心的思想。
     * dp[i][0]: 表示不持有股票； dp[i][1]: 表示持有股票
     * dp[i][0]= max(dp[i-1][0],dp[i-1][0] + prices[i]) dp[i][1] =max(dp[i-1][1] ,dp[i-1][0] - prices[i])
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices){

        // 初始化：
        int[][] dp = new int[prices.length][2];

        // 不持有股票
        dp[0][0]=0;
        // 持有股票
        dp[0][1] = -prices[0];
        for (int i=1;i<prices.length;i++){
            // 不持有股票：（ 前一天就没有持有；或者前一天持有，然后今天卖出）
            dp[i][0]= Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            // 持有股票：（ 前一天就持有股票；或者前一天不持有股票，然后今天买入）
            dp[i][1] =Math.max(dp[i-1][1], dp[i-1][0] -prices[i]);
        }
        return Math.max(dp[prices.length-1][0], dp[prices.length-1][1]);
    }
}



