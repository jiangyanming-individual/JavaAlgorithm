package LiKoHot100.动态规划;

import java.util.Map;

public class minPathSumDemo {


    /**
     *  最小路径和： 使用动态规划
     *  (1)  初始化第一列 和第一列， 其值是dp[i-1][0] = grid[i][j]
     *  (2) dp[i][j] =min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid){

        if (grid.length == 0 || grid[0].length == 0 || grid == null){
            return 0;
        }
        int m = grid.length;
        int n= grid[0].length;
        int [][] dp =new int[m][n];

        // 初始化dp；

        // 第一个数
        dp[0][0] =grid[0][0];
        // 初始化第一列
        for (int i=1;i<m;i++){
            dp[i][0] =dp[i-1][0] + grid[i][0];
        }
        // 初始化第一行
        for (int j=1;j<n;j++){
            dp[0][j]= dp[0][j-1] + grid[0][j];
        }

        // 进行遍历
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                dp[i][j]= Math.min(dp[i][j-1],dp[i-1][j]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}
