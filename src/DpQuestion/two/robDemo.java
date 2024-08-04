package DpQuestion.two;

public class robDemo {

    /**
     * 打家劫舍问题
     * @param nums
     * @return
     */
    public int rob(int [] nums){


        //dp[i] 考虑当前i个房子所能得到的最大金额；

        if (nums == null || nums.length ==0) return 0;
        if (nums.length== 1) return nums[0];
        int [] dp=new int[nums.length];
        dp[0]=nums[0];
        dp[1]= Math.max(nums[0],nums[1]);
        for (int i=2;i<nums.length;i++){
            //dp[i-1]是考虑不偷i,那就需要从i-1开始偷。 dp[i-2] + nums[i] 是考虑偷i, 那i-1不考虑；
            dp[i]=Math.max(dp[i-1],dp[i-2] + nums[i]);
        }
        //仅能取到length -1
        return dp[nums.length-1];
    }
}
