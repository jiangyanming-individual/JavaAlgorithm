package DpQuestion.two;

import java.util.Arrays;

public class lastStoneWeightIIDemo {


    public int lastStoneWeightII(int[] stones) {

        int sum = Arrays.stream(stones).sum();
        //背包容量
        int target = sum / 2;

        int[][] dp = new int[stones.length][target + 1];
        //初始化：
        for (int i = 0; i < stones.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= target; j++) {

            if (j < stones[0]) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = stones[0];
            }
        }

        for (int i = 1; i < stones.length; i++) {
            for (int j = 1; j <= target; j++) {

                if (j < stones[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i]] + stones[i]);
                }
            }
        }
        int maxValue= dp[stones.length-1][target];
        //剩余最小和
        return (sum -maxValue) -maxValue;
    }
}
