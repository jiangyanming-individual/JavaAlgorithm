package DpQuestion;

import java.util.Arrays;

public class canPartitionDemo {

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 5, 11, 5}));
    }
    public static boolean canPartition(int[] nums) {
        int sum= 0;
        for (int num : nums){
            sum +=num;
        }

        if (sum % 2!=0){
            return false;
        }

        //物品的容量和物品的大小都是本身
        int packSize = sum/2;

        int[] dp = new int[packSize + 1];
        Arrays.fill(dp,0);
        for (int i=0;i<nums.length;i++){
            for (int j=packSize; j>=nums[i];j--){
                dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]); //减重量，加价值：
            }
        }
//        System.out.println(dp[packSize]);
        return dp[packSize]==packSize;
    }
}
