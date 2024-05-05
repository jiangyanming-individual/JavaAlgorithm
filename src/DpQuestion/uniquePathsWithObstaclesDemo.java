package DpQuestion;

public class uniquePathsWithObstaclesDemo {

    public static void main(String[] args) {

        int[][] ints = new int[][] {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(ints));
    }

    /**
     *
     * 确定dp[i][j]含义 ：到达第i * j 有多少条路
     * 确定递推公式 ：dp[i][j]= dp[i][j-1] + dp[i-1][j]
     * 初始化dp dp[0]=0,dp[1]=1;
     * 确定遍历顺序
     * 模拟
     * */

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n]; //初始状态都是0

        //起点和终点出现了障碍直接返回0
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;

        //初始化：for 循环不满足直接退出
        for (int i = 0; i < m; i++){
            if (obstacleGrid[i][0]!=1){
                dp[i][0] = 1;
                continue; //初始化
            }
            break; //遇到障碍退出初始化
        }

        for (int j = 0; j < n; j++){
            if (obstacleGrid[0][j] !=1){
                dp[0][j] = 1;
                continue;
            }
            break; //遇到障碍退出初始化
        }

        /**
         * 确定遍历顺序
         */
        for (int i = 1; i < m; i++) {
            for (int j=1; j < n; j++) {
                if (obstacleGrid[i][j] == 1){
                    continue;
                }
                dp[i][j] = dp[i-1][j] + dp[i][j-1]; //递归公式
            }
        }
        return dp[m-1][n-1];
    }
}
