package DpQuestion.four;

public class numSquaresDemo {


    /**
     * 完全平方数 i* i=k, 是一个完全背包的问题
     * 返回和为n的最少的数量
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {

        // 定义dp
        int[] dp=new int[n+1];

        // 初始化dp
        dp[0]=0;

        // 其他初始化为最大值
        for (int i=1;i<dp.length;i++){
            dp[i]=Integer.MAX_VALUE;
        }
        // 先是遍历物品
        for (int i=1; i * i <= n;i++){
            // 遍历背包：
            for (int j=i * i ;j<=n;j++){
                if (dp[j - i * i] !=Integer.MAX_VALUE){
                    // 放入当前数和 不放入进行比较。
                    dp[j] = Math.min(dp[j], dp[j - i * i] +1);
                }
            }
        }
        return dp[n] == Integer.MAX_VALUE ? 0 : dp[n];
    }

}
