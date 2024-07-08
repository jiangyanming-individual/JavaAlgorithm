package DpQuestion.two;

public class fibDemo {

    public int fib(int n) {

        if (n < 2) {
            return n;
        }

        //dp定义
        int[] dp = new int[n + 1];
        //初始化dp
        dp[0] = 0;
        dp[1] = 1;
        //dp公式 dp[i] =dp[i-1] + dp[i-2];
        //遍历：
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        //取结果,dp 只能取到n
        return dp[n];
    }
}
