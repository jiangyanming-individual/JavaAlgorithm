package DpQuestion;

public class integerBreakDemo {

    /**
     * dp[i] 分拆数字i，可以得到的最大乘积为dp[i]。
     * dp[i] =Max(dp[i],Max(j * (i-j), j * dp[i-j]))
     * 初始化dp[2]=1
     * 确定遍历顺序
     * 模拟
     * @param n
     * @return
     */
    public int integerBreak(int n){

        int[] dp = new int[n + 1];
        dp[2]=1;
        //遍历顺序
        for (int i = 3; i <= n; i++){
            for (int j = 1; j <= i /2  ; j++) { //尽量让 j 和i-j大小接近
                dp[i]=Math.max(dp[i],Math.max(j * (i-j),j * dp[i-j])); //递推公式；每次需要更新dp[i]
            }
        }
        return dp[n]; //返回dp[n]
    }
}

