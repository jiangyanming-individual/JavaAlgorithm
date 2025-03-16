package DpQuestion.four;

public class coinChangeDemo {


    /**
     * 零钱兑换问题：
     * 1.  最少的硬币数，不要求排列顺序， 而且硬币的数量是无限的。
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {

        // 定义dp
        int[] dp=new int [amount+1];
        //初始化dp
        dp[0]=0;

        // 初始化dp, 其他的初始化为最大值：
        for (int i=1;i<dp.length;i++){
            dp[i] = Integer.MAX_VALUE;
        }

        // 遍历：
        for (int i=0;i<coins.length;i++){
            for (int j=coins[i];j<=amount;j++){
                // 递推公式： dp[j]=min(dp[j], dp[j - coins[i]] +1)
                if (dp[j - coins[i]]!=Integer.MAX_VALUE){
                    // 要保证dp[j-coins[i]] 是有效的
                    dp[j]=Math.min(dp[j],dp[j - coins[i]] +1);
                }

            }
        }
        // 返回结果：
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

}
