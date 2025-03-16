package Tanxin.three;

public class maxProfitDemo {


    /**
     * 1.买卖股票的最佳时机：
     * 2. [0][0]: 表示未持有股票
     *  [0][1]: 表示持有股票
     * 3. 卖出股票： dp[i][0]=Max(dp[i-1][0],dp[i-1][1] + prices[i]);
     *    买入股票： dp[i][1]=max(dp[i-1][1],dp[i-1][0] -prices[i]);
     * 4. 取最大的值
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // dp表示当前所获的最大的利润
        int[][] dp=new int[prices.length][2];// nums[n][2]
        // 初始化
        dp[0][0] =0;
        dp[0][1]=-prices[0];
        for (int i=1;i<prices.length;i++) {
            //当天卖出股票
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+ prices[i]);
            // 当天买入股票
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0] -prices[i]);
        }

        //取两者之间最的大值
        return Math.max(dp[prices.length-1][0],dp[prices.length-1][1]);
    }
}
