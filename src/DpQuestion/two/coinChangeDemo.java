package DpQuestion.two;

import java.util.Arrays;

public class coinChangeDemo {

    /**
     * 最少的个数,min
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        //初始化：
        int max = Integer.MAX_VALUE;
        dp[0] = 0; //下标为0 的初始化为0；
        for (int i = 1; i < dp.length; i++) {
            dp[i] = max;
        }
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                //求最少，对于数组的排序没有要求
                if (dp[j] != max) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}
