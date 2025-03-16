package DpQuestion.three;

import java.util.Arrays;

public class lastStoneWeightIIDemo {


    /**
     * 最后一块石头的重量：实际就是背包能装的最多的重量，然后总的 - 最多的重量
     * 1. sum / 2 是背包的容量，
     * 2. 定义dp 数组表示，能装的最大价值的石头, 初始化dp[i][0]和dp[0][j] (j<nums[0],全部初始化为0)
     * 3.max=dp[n-1][packageSize]:表示能装的最多的石头；
     * 4. (sum -max) - max: 两个大小相等的石头堆相碰，表示还剩余最少的石头。
     *
     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones) {

        int sum = Arrays.stream(stones).sum();

        // 背包容量
        int packageSize= sum / 2;
        // 定义dp

        int [][] dp=new int[stones.length][packageSize+1];

        //初始化：
        for (int i=0;i<stones.length;i++){
            dp[i][0]=0;
        }
        for (int j=0;j<=packageSize;j++){
            //背包容量要大于 stone[0]
            if (j<stones[0]){
                dp[0][j]=0;
            }else {
                dp[0][j]=stones[0];
            }
        }

        // 遍历数组：
        for (int i=1;i<stones.length;i++){
            for (int j=1;j<=packageSize;j++){
                if (j<stones[i]){
                    dp[i][j]=dp[i-1][j];
                }else {
                    //求packageSize 能装的最多的价值的石头
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j- stones[i]] + stones[i]);
                }
            }
        }

        // 能装的最多的石头：
        int max=dp[stones.length-1][packageSize];
        // 剩余最少的石头
        return  (sum -max) -max;
    }
}
