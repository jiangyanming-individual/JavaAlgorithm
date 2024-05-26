package DpQuestion;

public class findTargetSumWaysDemo {
    /**
     * 目标和： 为什么是01背包，因为只使用一次：
     * left + right = sum ==> right = sum -left
     * left -right= target=== > left - ( sum  - left ) = target ==> left =( sum + target) /2
     * bagSize= left
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum +=nums[i];
        }
        if (Math.abs(target) > sum) return  0; //target > sum 不符合条件；
        if ((sum + target) % 2 != 0) return 0; //不符合条件
        int bagSize =(sum + target) /2 ;
        //dp[j]的含义：表示容量为j的背包，有多少种组合方式：
        int[] dp = new int[bagSize + 1];
        //初始化：dp[0]一定是1 ，因为后面的值都是由dp[0]推出来的。
        dp[0]=1;
        //确定遍历顺序
        for (int i = 0; i < nums.length; i++) {
            for (int j=bagSize;j>=nums[i];j--){
                dp[j] +=dp[j-nums[i]];// 组合进行累加；
            }
        }
        //返回最后的结果：
        return dp[bagSize];
    }
}
