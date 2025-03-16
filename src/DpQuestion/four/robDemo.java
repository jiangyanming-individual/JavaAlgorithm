package DpQuestion.four;

public class robDemo {


    /**
     *
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {

        if (nums.length == 0) return 0;
        if (nums.length ==1) return  nums[0];
        // 定义dp, 偷当前房子所能获取到最多金额
        int [] dp=new int[nums.length];
        // 初始化dp:
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);

        // 遍历：
        for (int i=2;i<nums.length;i++){
            // 偷当前房子和不偷当前房子：
            dp[i]= Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        // 返回结果：
        return dp[nums.length-1];
    }
}