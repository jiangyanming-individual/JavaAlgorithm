package DpQuestion.three;

import java.util.Arrays;

public class canPartitionDemo {


    /**
     * 1. 先求和，然后求出总和的一半，就是背包的容量，也是背包的价值
     * 2. 定义dp
     * 3. 初始化dp, dp[i][0]=0, dp[0][0]=0,dp[0][j]= nums[0];
     * 4. 先遍历物品，再遍历背包， dp[i][j]=max(dp[i-1][j],dp[i-1][j-nums[i]] + nums[i]);
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {


        int sum = Arrays.stream(nums).sum();
        // 如果不能平分，就直接返回false
        if (sum % 2 !=0) {
            return false;
        }

        int packageSize= sum /2;
        // 定义dp
        int[][] dp=new int[nums.length][packageSize+1];

        // 初始化：
        for (int i=0;i<nums.length;i++){
            dp[i][0]=0;
        }
        for (int j=0;j<=packageSize;j++){
            if (j<nums[0]){
                dp[0][j]=0;
            }else {
                dp[0][j]=nums[0];
            }
        }

        //遍历：先遍历物品再遍历背包：
        for (int i=1;i<nums.length;i++){
            for (int j=0;j<=packageSize;j++){
                if (j<nums[i]){
                    dp[i][j]=dp[i-1][j];
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-nums[i]] + nums[i]);
                }
            }
        }
        // 返回结果
        return dp[nums.length - 1][packageSize] == packageSize;
    }
}
