package DpQuestion.two;

public class integerBreakDemo {
    public int integerBreak(int n) {

        if (n <= 2) {
            return 1;
        }
        //i==n 所能达到的最大乘积
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;

        //dp[i] = max(dp[i], max((i - j) * j, dp[i - j] * j));
        for (int i = 3; i <= n; i++) {
            //尽量让拆分的两者接近：
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
