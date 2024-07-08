package DpQuestion.two;

public class uniquePathsDemo {

    /**
     * 注意定义的数组别越界
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePath(int m, int n) {
        int[][] dp = new int[m][n];
        //dp[i][j]=dp[i-1][j] + dp[i][j-1];

        //初始化第0列
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        //初始化第0行
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        //遍历：
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
