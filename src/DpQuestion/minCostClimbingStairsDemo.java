package DpQuestion;

import java.util.Map;

public class minCostClimbingStairsDemo {

    public static void main(String[] args) {
        int[] ints = new int[]{10,15,20};
        System.out.println(minCostClimbingStairs(ints));
    }

    /**
     *
     * 确定dp[i]含义 ：到达第i台阶所花费的最少体力为dp[i]。
     * 确定递推公式 ：dp[i]= min(dp[i-1] + cost[i-1],dp[i-2] + cost[i-2])
     * 初始化dp dp[0]=0,dp[1]=1;
     * 确定遍历顺序
     * 模拟
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs(int[] cost){

        int[] dp = new int[cost.length + 1];
        //0 和 1是不花费体力
        dp[0]=0;
        dp[1]=0;

        for (int i = 2; i <=cost.length; i++) {
            dp[i]= Math.min(dp[i-1] + cost[i-1],dp[i-2] + cost[i-2]);
        }
        return dp[cost.length]; //取到length
    }
}
