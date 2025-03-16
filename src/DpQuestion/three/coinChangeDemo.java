package DpQuestion.three;

public class coinChangeDemo {


    /**
     * 1. 零钱兑换问题：完全背包问题，物品可以无线使用。
     * 2. 不用考虑排序的问题， dp[i]表示所需要的最少硬币。
     * 3. 初始化dp[0]=0, dp[i] =Integer.MAX_VALUE。
     * 4. 递推公式： dp[j] =min(dp[j],dp[j-coins[i]] +1)  ： 放当前物品和不放当前物品所需的最少硬币。
     * 5. 只有当dp[j-coins[i]]!=Integer.MAX_VALUE, 才可以进行递推。
     * 6. 如果dp[amount] == Integer.MAX_VALUE 则直接返回 -1
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {

        // 定义dp[i]; 表示构成amount 数量金额的所需要的最少的硬币
        int[] dp = new int[amount + 1];
        // 初始化dp[0];
        dp[0]=0;

        // 其他的数组元素需要初始化为较大的值；
        for (int i=1;i<dp.length;i++){
            dp[i]=Integer.MAX_VALUE;
        }
        // 递推公式 dp[j] =min(dp[j], dp[j - coins[i]] +1)。 放当前的硬币和不放当前的银币。

        // 遍历：先物品再背包：
        for (int i=0;i<coins.length;i++){
            for (int j=coins[i];j<=amount;j++){
                // 只有当dp[j-coins[i]] 是有效的数值时才可以
                if (dp[j-coins[i]]!=Integer.MAX_VALUE){
                    // 当前背包的最少银币，
                    dp[j]=Math.min(dp[j],dp[j-coins[i]] +1);
                }
            }
        }
        // 返回结果：
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

}
