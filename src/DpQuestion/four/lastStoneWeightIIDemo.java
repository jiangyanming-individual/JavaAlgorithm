package DpQuestion.four;

import java.util.Arrays;

public class lastStoneWeightIIDemo {


    /**
     * 最后一块石头的重量2：
     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones) {

        int sum = Arrays.stream(stones).sum();
        // 背包的容量，装满背包需要多少
        int packageSize= sum /2;
        // 定义dp
        int[][] dp=new int[stones.length][packageSize+1];

        // 初始化dp
        for (int i=0;i<stones.length;i++){
            dp[i][0]=0;
        }
        for (int j=0;j<=packageSize;j++){
            if (j<stones[0]){
                dp[0][j]=0;
            }else {
                dp[0][j]=stones[0];
            }
        }
        //遍历：
        for (int i=1;i<stones.length;i++){
            for (int j=1;j<=packageSize;j++){

                if (j<stones[i]){
                    dp[i][j]=dp[i-1][j];
                }else {
                    // 所能得到的最大的价值：
                    dp[i][j] =Math.max(dp[i-1][j],dp[i-1][j- stones[i]] + stones[i]);
                }
            }
        }

        // packageSize能装的最大重量的石头：
        int max= dp[stones.length-1][packageSize];
        // 两块石头相碰的最少的重量：
        return (sum -max) -max;
    }
}
