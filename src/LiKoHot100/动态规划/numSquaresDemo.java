package LiKoHot100.动态规划;

public class numSquaresDemo {

    /**
     * 动态规划； 初始化dp[0]=0; dp[i]=Integer.MAX_VALUE
     * 状态转移方程： dp[i] =min(dp[i], dp[i- j * j] +1)
     * @param n
     * @return
     */
    public int numSquares(int n){
        // 创建一个长度为 n + 1 的数组 dp，用于存储每个数对应的最少完全平方数数量
        int[] dp = new int[n + 1];
        // 初始化 dp 数组，将除 dp[0] 外的元素初始化为最大值
        for (int i=1;i<=n;i++){
            dp[i]= Integer.MAX_VALUE;
        }
        // dp[0]=0;
        dp[0]=0;
        // 从1开始遍历数：
        for (int i=1;i<=n ;i++){
            // 遍历所有可能的完全平方数
            for (int j=1; j * j <=i;j++){
                // 状态转移方程：更新 dp[i] 的值为当前值和 dp[i - j * j] + 1 中的较小值
                dp[i]=Math.min(dp[i], dp[i- j * j] +1);
            }
        }
        // 返回结果：
        return dp[n];
    }
}
