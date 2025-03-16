package DpQuestion.four;

public class changeDemo {


    /**
     * 零钱对换： 完全背包问题
     * 1. dp[i]
     * 2. 初始化dp[i] =1
     *
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {

        // 定义dp
        int[] dp=new int[amount+1];

        // 初始化dp[0]=1, dp[0]初始化没有意义：
        dp[0]=1;
        // 组合，先遍历物品再遍历背包
        for (int i=0;i<coins.length;i++){
            // 背包, 第一个要放物品coin[i]
            for (int j=coins[i];j<=amount;j++){
                // 递推公式：放物品i和不放物品i
                dp[j]= dp[j] + dp[j- coins[i]];
            }
        }


        // 先背包再物品，要求排列数
//        for (int j=0;j<=amount;j++){
//            // 背包, 第一个要放物品coin[i]
//            for (int i=0;i< coins.length;i++){
//                // 递推公式：放物品i和不放物品i,
//                if (j - coins[i]>=0){
//                    // 这个差值要大于等于0
//                    dp[j] =dp[j] + dp[j- coins[i]];
//                }
//            }
//        }

        // 返回结果
        return dp[amount];
    }
}
