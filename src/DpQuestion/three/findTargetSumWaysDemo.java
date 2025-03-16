package DpQuestion.three;

import java.util.Arrays;

public class findTargetSumWaysDemo {


    /**
     * 1. 目标和： 设加法和与减法和的总和为sum。 加法的和为packageSize, 减法的和为 （sum- packageSize） 。 加法的总和和减法的总和是sum
     * 可以找到关系==> packageSize - (sum -packageSize) =target
     * packageSize= (target + sum ) /2 , 即 问加法的总和为packageSize 有多少种方法。
     *
     * 特殊情况： 如果 (target + sum) / 2 !=0则表示没有解，
     * 如果 abs(target)>sum ，这样也表示没有解的。
     *
     * 2. 定义dp[][] 表示达到背包容量为packageSize 一共有多少种方法
     * 3. 初始化dp[0][j] :dp[0][0]=1, dp[0][nums[0]] =1 , dp[0][大于nums[0]]=0;
     * 4. 初始化dp[i][0]: dp[0][0]=1: 容量为0， 使用物品0的方法只有一种。
     * 当背包容量为0时： 如果有两个物品，物品0为0， 物品1为0，装满背包容量为0的方法有几种。 2 ^ t种解法；
     *
     * (1)放0件物品
     * (2)放物品0
     * (3)放物品1
     * (4)放物品0 和 物品1
     * 5. 递推公式：放物品i和不放物品i： ===>  dp[i][j] = dp[i-1][j]  + dp[i-1][j -nums[i]];
     *
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {

        int sum = Arrays.stream(nums).sum();

        //两种特殊的情况
        int packageSize =(target + sum) /2; 
        if (packageSize % 2 !=0) return 0;
        if (Math.abs(target) > sum) return 0;
        
        // 定义dp
        int[][] dp=new int[nums.length][packageSize +1];
        
        // 初始化
        int numZeros=0;
        for (int i=0;i<nums.length;i++){
            // 统计物品是0的个数：
            if (nums[i] == 0) {
                numZeros ++;
            }
            // 2 的次幂
            dp[i][0] = (int)Math.pow(2, numZeros);
        }
        
        // 初始化第一行；
        for (int j=1;j<=packageSize;j++){
            if (j < nums[0]){
                dp[0][j]=1;
            }
            // 其余的都为0；
        }

        // 先遍历物品，再遍历背包：
        for (int i=1;i<nums.length;i++){
            
            for (int j=1;j<=packageSize;j++){
                if (j<nums[i]){
                    dp[i][j]=dp[i-1][j];
                }else {
                    dp[i][j]=dp[i-1][j]+dp[i-1][j- nums[i]];
                }
            }
        }
        // 返回结果：
        return dp[nums.length-1][packageSize];
    }
}
