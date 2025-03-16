package DpQuestion.three;

public class maxProfitDemo4 {


    /**
     * 买卖股票的最佳时机4：  其实跟买卖股票3很相似
     * 1. 初始化
     *    for (int i=1;i<= 2 * k - 1;i++){
     *             // 买入：奇数
     *             dp[0][i]=-prices[0];
     *             // 其他都是卖出：
     *         }
     * 2. 遍历j的下标： for(j =0;j<= 2 * k-2; j +=2)
     * 3. 递推公式：
     *     //买入
     *     dp[i][j+1]= Math.max(dp[i-1][j+1], dp[i-1][j] -prices[i]);
     *     // 卖出：
     *     dp[i][j+2] =Math.max(dp[i-1][j+2],dp[i-1][j+1] + prices[i]);
     *
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        //定义dp
        int[][] dp =new int[prices.length][2 * k +1];

        //初始化， 每次都需要进行加2的操作，因为有买入和卖出这两个操作
        for (int i=1;i<= 2 * k - 1;i+=2){
            // 买入：奇数
            dp[0][i]=-prices[0];
            // 其他都是卖出：
        }

        // 遍历：
        for (int i=1;i<prices.length;i++){
            //对于不同的 j进行调整, j能取到的最大值就是2k
            for (int j=0;j<=2 * k-2;j+=2){
                //买入
                dp[i][j+1]= Math.max(dp[i-1][j+1], dp[i-1][j] -prices[i]);
                // 卖出：
                dp[i][j+2] =Math.max(dp[i-1][j+2],dp[i-1][j+1] + prices[i]);
            }
        }
        // 最后卖出，一定是赚到的；
        return dp[prices.length-1][2 * k];
    }
}
