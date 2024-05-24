package DpQuestion;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //种类
        int M = scanner.nextInt();
        //背包容量
        int N = scanner.nextInt();

        int[] weights = new int[M];
        int[] values= new int[M];
        //重量
        for (int i = 0; i < M; i++) {
            weights[i] = scanner.nextInt();
        }
        //价值
        for (int i = 0; i < M; i++) {
            values[i] = scanner.nextInt();
        }

        int[][] dp = new int[M][N + 1];
        //小于第一个物品大小的全部赋值为0
        for (int j = 0; j < weights[0]; j++) {
            dp[0][j]=0;
        }

        for (int j=weights[0];j<=N;j++) {
            dp[0][j]=values[0];
        }
        //遍历：
        for (int i=1;i<=M-1;i++){
            for (int j=0;j<=N;j++){
                if (j<weights[i]){
                    dp[i][j]=dp[i-1][j];
                }else {
                    //取最大的：
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weights[i]]+values[i]);
                }
            }
        }

        //返回结果
        System.out.println(dp[M-1][N]);
    }
}
