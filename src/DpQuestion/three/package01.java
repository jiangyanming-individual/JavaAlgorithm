package DpQuestion.three;

import java.util.Scanner;

public class package01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int bagweight = scanner.nextInt();

        int[] weight = new int[n];
        int[] value = new int[n];

        // 物品重量
        for (int i = 0; i < n; i++) {
            weight[i] = scanner.nextInt();
        }
        // 物品价值
        for (int j = 0; j < n; j++) {
            value[j] = scanner.nextInt();
        }
        // 定义dp, 二维dp数组表示当前所能获取到的最大价值 (m行，n+1列)
        int [][] dp=new int[n][bagweight +1];

        // 初始化第一列： 全部为0
        for (int i=0;i<n;i++){
            dp[i][0]=0;
        }
        // 第一行为： value[0]
        for (int j=0;j<=bagweight;j++){
            dp[0][j]=value[0];
        }

        // 先遍历物品，再遍历背包
        for (int i=1;i<n;i++){
            for (int j=1;j<=bagweight;j++){
                //如果背包容量不够放入当前物品， 那dp[i][j] =dp[i-1][j]
                if (j< weight[i]){
                    dp[i][j]=dp[i-1][j];
                }else {
                    // 不加入物品i 和加入物品i后能获取到最大价值：
                    dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j - weight[i]] + value[i]);
                }
            }
        }
        // 物品下标取到n-1
        System.out.println(dp[n-1][bagweight]);
    }
}
