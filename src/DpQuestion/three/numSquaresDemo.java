package DpQuestion.three;

public class numSquaresDemo {


    /**
     * 完全平方数： i * i = k
     * 1. 初始化 dp[0]=0, dp[i] =max
     * 2. 递推公式 dp[j] =min(dp[j],dp[j - i * i] +1);
     * 3. dp[j - i * i] != Integer.MAX_VALUE 不放入物品要真实有效。
     * @param n
     * @return
     */
    public int numSquares(int n) {
        // 定义dp[i] 表示和为 n 的完全平方数最少数量
        int[] dp = new int[n + 1]; // 一维滚动数组是被压缩了的
        // 初始化
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        // 递推公式： dp[j] =min(dp[j] ,dp[j - i * i] +1) 放入i * i的最少的数量

        //遍历物品：完全平方不能大于n
        for (int i = 1; i * i < n; i++) {
            // 遍历背包：
            for (int j = i * i; j <= n; j++) {
                if (dp[j - i * i] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }
        return dp[n]  == Integer.MAX_VALUE ? 0 : dp[n];
    }
}
