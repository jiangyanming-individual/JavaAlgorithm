package DpQuestion.four;

import java.util.Arrays;

public class findTargetSumWaysDemo {


    /**
     * 目标和： x - (sum -x) =target
     *
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {

        int sum = Arrays.stream(nums).sum();

        //特殊条件：
        if (Math.abs(target) > sum) return 0;
        // 除不净
        if ((sum + target) % 2 !=0) return 0;

        //背包容量： 加法和的总和
        int packageSize= (sum + target) /2;

        // dp表示： 下标为i 的能有多少种方法组成：
        int [][] dp=new int[nums.length][packageSize+1];

        //初始化第一列
        int numZeros=0;
        for (int i=0;i<nums.length;i++){

            // 如果背包为0的话：
            if (nums[i] == 0){
                numZeros++;
            }
            // 2的次幂
            dp[i][0]= (int) Math.pow(2, numZeros);
        }

        //初始化第一行； 下标从1开始，因为0是第一列已经初始化过了
        for (int j=1;j<=packageSize;j++){
            // 等于j的就可以有一种方法：
            if (j==nums[0]){
                dp[0][j] =1;
            }
            // 其他的都是0；
        }

        // 遍历
        for (int i=1;i<nums.length;i++){
            for (int j=1;j<=packageSize;j++){

                // 不放
                if (j<nums[i]){
                    dp[i][j]=dp[i-1][j];
                }else {
                    // 累加和
                    dp[i][j]=dp[i-1][j]+ dp[i-1][j-nums[i]];
                }
            }
        }
        // 返回结果
        return  dp[nums.length-1][packageSize];
    }
}
