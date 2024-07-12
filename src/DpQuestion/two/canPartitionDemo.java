package DpQuestion.two;

import java.util.Arrays;

public class canPartitionDemo {


    /**
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {

        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int packageSize = sum / 2;
//        int[] dp = new int[packageSize + 1];
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = packageSize; j >= nums[i]; j--) {
//                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
//            }
//        }

        //二维数组实现：
        int[][] dp = new int[nums.length][packageSize + 1];
        //dp[i][j]=max(dp[i-1][j],dp[i-1][j-weight[i]] + value[i]);

        //初始化：
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= packageSize; j++) {
            if (j < nums[0]) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = nums[0];
            }
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= packageSize; j++) {
                if (j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                }
            }
        }

        return dp[nums.length - 1][packageSize] == packageSize ? true : false;
    }
}
