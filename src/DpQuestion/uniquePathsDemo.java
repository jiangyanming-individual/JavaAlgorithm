package DpQuestion;

import java.util.Scanner;

public class uniquePathsDemo {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        String[] split = s.split(" "); //分割字符串
        int m = Integer.parseInt(split[0]); //解析
        int n = Integer.parseInt(split[1]);

        System.out.println(uniquePaths(m, n));
        scanner.close();
    }

    /**
     *
     * 确定dp[i][j]含义 ：到达第i * j 有多少条路
     * 确定递推公式 ：dp[i][j]= dp[i][j-1] + dp[i-1][j]
     * 初始化dp dp[i][0]=1,dp[0][j]=1;
     * 确定遍历顺序
     * 模拟
     * */
    public static int uniquePaths(int m,int n){

        int[][] dp = new int[m][n];
        //初始化dp[i][j]
        for (int i = 0; i < m; i++) {
            dp[i][0]=1;
        }

        for (int j = 0; j < n; j++) {
            dp[0][j]=1;
        }

        for (int i = 1;i<m;i++){
            for (int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
