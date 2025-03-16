package DpQuestion.four;

import java.util.Arrays;
import java.util.Map;

public class canPartitionDemo {


    /**
     * 分割等和子集：
     *
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {

        int sum = Arrays.stream(nums).sum();
        int packageSize= sum/ 2;
        // 不能整除0就直接返回false
        if (packageSize % 2 !=0){
            return false;
        }

        // 定义dp所能得到的最大价值
        int [][] dp=new int[nums.length][packageSize+1];

        // 初始化dp
        for (int i=0;i<nums.length;i++){
            dp[i][0]=0;
        }

        for (int j=nums[0];j<=packageSize;j++){
            if (j<nums[0]){
                dp[0][j]=0;
            }else {
                dp[0][j]= nums[0];
            }
        }
        // 先遍历物品再遍历背包：
        for (int i=1;i<nums.length;i++) {
            for (int j=1;j<=packageSize;j++){
                // 如果放不下的话：
                if (j<nums[0]){
                    dp[i][j]=dp[i-1][j];
                }else {
                    dp[i][j]= Math.max(dp[i-1][j],dp[i-1][j-nums[i]] + nums[i]);
                }
            }
        }
        //判断最终的结果是否是packageSize；
        return dp[nums.length-1][packageSize] == packageSize;
    }
}
