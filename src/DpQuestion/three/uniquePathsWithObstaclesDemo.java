package DpQuestion.three;

public class uniquePathsWithObstaclesDemo {

    /**
     *
     * 不同路径2
     * 1. 定义dp
     * 2. 初始化dp, 需要特判，当前的节点不为障碍物
     * 3. 特殊判断： 如果obstacleGrid[i][j] ==1,遇到障碍物直接跳过, 递推公式： dp[i][j] = dp[i-1][j] + dp[i][j-1];
     * 4. 返回结果： dp[m-1][n-1];
     *
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m=obstacleGrid.length;
        int n =obstacleGrid[0].length;

        int[][] dp=new int[m][n];
        // 开头和结尾有障碍物，直接返回0；
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1]==1 ){
            return 0;
        }

        // 初始化行；并且当前的节点的不能障碍物
        for (int i=0;i<m && obstacleGrid[i][0] ==0; i++){
            dp[i][0]=1;
        }

        // 初始化列
        for (int j=0;j<n && obstacleGrid[0][j] == 0;j++){
            dp[0][j]=1;
        }

        //遍历数组：
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                //obstacleGrid[i][j] ==1 ,遇到障碍物，直接跳过；
                if (obstacleGrid[i][j] ==1 ){
                    continue;
                }
                // 递推公式
                dp[i][j]=dp[i-1][j] + dp[i][j-1];
            }
        }
        // 返回结果
        return dp[m-1][n-1];
    }
}
