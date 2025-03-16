package DpQuestion.five;

import java.util.Arrays;

public class findTargetSumWaysDemo {



    // 多重背包是遍历顺序可以随意：




    /**
     * 目标和：
     *
     * x ：加法的和 ， sum-x： 减法的和
     * 1. x - (sum -x) = target ==> x = (sum + target) /2
     *
     *
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {

        int sum = Arrays.stream(nums).sum();

        // 两种特殊的情况
        if ((sum + target) % 2 !=0){
            return 0;
        }

        if (Math.abs(target)> sum){
            return 0;
        }
        int packageSize= (sum + target) /2 ;

        // 定义dp, 加法和为packageSize有多少种情况
        int [][] dp=new int[nums.length][packageSize+1];

        // 初始化dp
        int zeroNums=0;
        for (int i=0;i<nums.length;i++){
            // 如果当前物品为0
            if (nums[i] == 0){
                zeroNums++;
            }
            // 第一列初始化： 当背包容量为0时，可能的可能性是2的次幂
            dp[i][0]=(int)Math.pow(2, zeroNums);
        }
        // 初始化第一行，除了物品0和背包容量相等的情况j== num[0] 是有一种可能，其他情况都为0
        for (int j=1;j<=packageSize;j++){
            if (j == nums[0]){
                dp[0][j]= 1;
            }
        }
        // 遍历：
        for (int i=1;i<nums.length;i++){
            for (int j=1;j<=packageSize;j++) {
                if (j<nums[i]){
                    dp[i][j]=dp[i-1][j];
                }else {
                    // 不加物品i 和加物品i的总和
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i]];
                }
            }
        }

        // 返回结果
        return dp[nums.length-1][packageSize];
    }
}
