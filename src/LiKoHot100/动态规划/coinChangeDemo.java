package LiKoHot100.动态规划;

public class coinChangeDemo {


    /**
     * 硬币零钱兑换： 完全背包问题： 物品可以放多次；
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount){
        int[] dp = new int[amount + 1];
        //初始化dp，达到当前的金额所需的最少的金额：
        dp[0]=0;
        for (int i=1;i<dp.length;i++){
            dp[i]=Integer.MAX_VALUE;
        }
        //先遍历物品再遍历背包
        for (int i=0;i<coins.length;i++){
            for (int j=coins[i];j<=amount;j++){
                // 如果当前的个数不是最大值， 保证dp[j- coins[i]]是有效的
                if (dp[j -coins[i]] != Integer.MAX_VALUE){
                    // 统计最少的个数：
                    dp[j]=Math.min(dp[j], dp[j-coins[i]] + 1);
                }
            }
        }
        // dp[amount]是可以取到，因为就是为了求amount 金额下最少的硬币个数
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
