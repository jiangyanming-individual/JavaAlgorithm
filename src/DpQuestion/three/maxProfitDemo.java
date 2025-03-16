package DpQuestion.three;

public class maxProfitDemo {

    /**
     * 最大利润：(1) 动态规划的思想，(2) 贪心策略
     * 需要二维数组来表示状态
     * 1. dp[i][0] 表示持有股票， dp[i][1] 表示不持有股票
     * 2. 递推公式： dp[i][0]=max(dp[i-1][0],-prices[i]) dp[i][1]=Max(dp[i-1][1], dp[i-1][0] + prices[i])
     * 3. 持有股票和不持有股票的最大值：
     * 4. 注意当前股票只能买卖一次
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // 定义dp
        int [][] dp=new int[prices.length][2];

        // 初始化：
        dp[0][0]= -prices[0];
        dp[0][1]= 0;
        //遍历
        for (int i=1;i<prices.length;i++){
            dp[i][0]=Math.max(dp[i-1][0], -prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0] + prices[i]);
        }
        // 找到持有股票和不持有股票的最大值
        return Math.max(dp[prices.length-1][0],dp[prices.length-1][1]);
    }


    /***
     *
     * 使用贪心策略：
     * 1.使用一个变量记录最小的价格
     * 2.使用一个变量记录最大的利润
     * 3. 遍历进行最多利润的更新
     */
    public int maxProfit2(int[] prices) {

        int minPrice= Integer.MAX_VALUE;
        int maxProfit= 0;

        // 遍历数组：
        for (int i=0;i<prices.length;i++){
            if (prices[i]<minPrice){
                // 更新最小的股价：
                minPrice= prices[i];
            }else if (prices[i] - minPrice>maxProfit){
                // 更新最大的利润
                maxProfit= prices[i] - minPrice;
            }
        }

        // 返回更大的利润：
        return  maxProfit;
    }

}
