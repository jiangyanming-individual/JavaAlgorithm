package DpQuestion.three;

import java.util.Scanner;

public class minCostClimbingStairsDemo {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();

        int [] nums=new int[n];
        for (int i=0;i<n;i++){
            nums[i]=scanner.nextInt();
        }
        minCostClimbingStairs(nums);
    }
    /**
     * 使用最小的花费爬楼梯
     * 1. 定义dp[i]是 爬到i层所需要的最少花费
     * 2. 第0层和第1层初始化为0, dp[0] =0, dp[1]=0;
     * 3. 递推公式： dp[i] = min(dp[i-1] + cost[i-1] + dp[i-2] + cost[i-2]);
     * 4. 返回最少结果；
     * @param cost
     * @return
     */
    public  static int minCostClimbingStairs(int[] cost) {


        //爬到i的最小花费,
        int[] dp=new int[cost.length+1];

        // 初始化：
        dp[0]=0;
        dp[1]=0;
        // 遍历：
        for (int i=2;i<=cost.length;i++){
            // cost[i] 是向上爬所需要的费用：
            dp[i]=Math.min(dp[i-1]+ cost[i-1],dp[i-2] + cost[i-2]);
        }
        // 返回数组：
        System.out.println(dp[cost.length]);

        for (int i : cost) {
            System.out.println(i);
        }
        //返回最少的花费：
        return dp[cost.length];
    }
}
