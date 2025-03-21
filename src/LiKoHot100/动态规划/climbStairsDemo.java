package LiKoHot100.动态规划;

public class climbStairsDemo {


    /**
     * 爬楼梯: 使用动态规划的思想： dp[i] = dp[i-1] + dp[i-2]
     * @return
     */
    public int  climbStairs(int n){

        if (n<2){
            return n;
        }
        int[] dp = new int[n + 1];

        // 初始化dp
        dp[0]=1;
        dp[1]=1;
        for (int i=2;i<=n;i++){
            dp[i] = dp[i-1] +dp[i-2];
        }
        return dp[n];
    }
}
