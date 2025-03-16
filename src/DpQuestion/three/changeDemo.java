package DpQuestion.three;

public class changeDemo {


    /**
     * 零钱兑换2:
     *
     * 1. 定义dp
     * 2. 初始化dp， dp[0]=1
     * 3. 递推公式： dp[j] =dp[j] + dp[j-nums[i]];
     * 4. 返回dp
     *
     * @param amount
     * @param coins
     * @return
     */

    public int change(int amount, int[] coins) {
        // 定义dp, 表示总量为amount的背包可以有多少总方式
        int [] dp=new int[amount+1];

        // 初始化dp
        dp[0]=1;
        //  遍历：
        for (int i=0;i<coins.length;i++){
            for (int j=coins[i];j<=amount;j++){
                // 递推公式：不放物品i 和放物品所能得到的总和进行累加
                dp[j]=dp[j] + dp[j- coins[i]];
            }
        }
        // 返回总和
        return dp[amount];
    }

}