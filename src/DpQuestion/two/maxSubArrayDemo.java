package DpQuestion.two;

public class maxSubArrayDemo {

    public int maxSubArray(int[] nums) {

        if (nums.length == 1) return nums[0];
        //定义dp；到下标为i的数据时，所得的最大和
        int[] dp=new int[nums.length];
        // 初始dp;
        dp[0]=nums[0];
        //结果res：
        int res=nums[0];
        for (int i=1;i<nums.length;i++){
            // dp[i]的值： dp[i-1] + nums[i] 或者从头开始的nums[i];
            dp[i]=Math.max(dp[i-1] + nums[i], nums[i]);
            if (dp[i] > res){
                res=dp[i];
            }
        }
        return res;
    }
}
