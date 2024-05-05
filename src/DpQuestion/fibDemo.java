package DpQuestion;

public class fibDemo {

    /**
     * 明确dp[i]
     * 确定递推公式
     * 递推初始化
     * 确定地推遍历顺序
     * 举例子dp
     * @return
     */
    public int fib(int n){

        if (n<=1){
            return n;
        }

        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;

        //递推遍历顺序，从前往后：
        for (int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2]; //递推公式；
        }
        //取值
        return dp[n];
    }
}
