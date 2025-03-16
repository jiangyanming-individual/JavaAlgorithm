package DpQuestion.three;

public class maxProfitDemo5 {

    /**
     * 股票最佳买卖时期，含有冷冻期,而且不能参与多笔交易
     *
     * 1. 四种状态： (1) 当前持有股票 (2) 前几天就卖出股票了，保持卖出股票的状态 (3) 今天卖出股票 (4) 冷冻期
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        //定义dp
        int[][] dp=new int[prices.length][4];
        // 初始化dp
        dp[0][0]=-prices[0];
        // (1) 持有股票，(2) 保持卖出股票，(3) 今天卖出 (4) 冷冻期
        for (int i=1;i<prices.length;i++) {

            // 持有股票： （1）前一天就持 (2) 前一天是在冷冻期，今天买入 (3) 前几天就已经保持卖出了，今天买入
            dp[i][0]=Math.max(dp[i-1][0],Math.max(dp[i-1][1] - prices[i],dp[i-1][3] - prices[i]));
            // 保持卖出股票。 前一天就卖出了， 或者前一天是冷冻期，大前天卖的
            dp[i][1]=Math.max(dp[i-1][1], dp[i-1][3]);
            // 今天卖出，说明前一天持有股票
            dp[i][2] =dp[i-1][0] + prices[i];
            //冷冻期: 昨天卖出股票今天不操作
            dp[i][3] =dp[i-1][2];
        }
        // 返回最大的结果：
        return Math.max(dp[prices.length-1][3],Math.max(dp[prices.length-1][1],dp[prices.length-1][2]));

    }
}
