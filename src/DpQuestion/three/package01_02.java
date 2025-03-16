package DpQuestion.three;

import java.util.Scanner;

public class package01_02 {

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
        scanner.close();
        // 定义dp数组：
        int [] dp=new int[bagweight+1];
        //初始化dp，初始化dp=0;
        for (int i=0;i<n;i++){
            for (int j=bagweight;j>=weight[i];j--){
                // 取最大的值：
                dp[j]=Math.max(dp[j], dp[j -weight[i]] + value[i]);
            }
        }
        // bagesize
        System.out.println("结果：" + dp[bagweight]);
    }
}
