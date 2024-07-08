package DpQuestion.two;

public class minCostClimbingStairsDemo {

    /**
     * 最小花费爬楼梯的
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStair(int[] cost) {

        //dp[i]的定义：到达第i台阶所花费的最少体力为dp[i]。
        int[] dp = new int[cost.length + 1];
        //从下标0或者1是不花费体力
        dp[0] = 0;
        dp[1] = 0;

        //公式 dp[i] =min(dp[i-1] + cost[i], dp[i-2] + cost[i])
        //遍历顺序
        for (int i = 2; i <= cost.length; i++) {
            //到达i-1 需要最小体力为dp[i-1],要登山i层，需要花费cost[i-1]
            dp[i] = Math.min(dp[i - 1] + cost[i-1], dp[i - 2] + cost[i-2]);
        }
        return dp[cost.length];
    }

}
