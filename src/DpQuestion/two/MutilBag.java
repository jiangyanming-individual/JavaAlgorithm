package DpQuestion.two;

import java.util.Scanner;

public class MutilBag {

    /**
     * 多重背包，实际就摊开的o1背包问题
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /**
         * bagWeight:背包容量
         * n:物品种类
         */
        int bagWeight, n;
        //获取用户输入数据，中间用空格隔开，回车键换行
        bagWeight = sc.nextInt();
        n = sc.nextInt();
        int[] weight = new int[n];
        int[] value = new int[n];
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) weight[i] = sc.nextInt();
        for (int i = 0; i < n; i++) value[i] = sc.nextInt();
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

        int[] dp = new int[bagWeight + 1];
        //先遍历物品
        for (int i=0;i<weight.length;i++){
            //遍历背包：
            for (int j=bagWeight;j>=weight[i];j--){
                //n 个物品
                for (int k=1;k<=nums[i] && (j- k * weight[i]>=0);k++){
                    dp[j]=Math.max(dp[j],dp[j- k * weight[i]] + k * value[i]);
                }
            }
        }

        System.out.println(dp[bagWeight]);

    }
}
