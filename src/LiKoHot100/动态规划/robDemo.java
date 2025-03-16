package LiKoHot100.动态规划;

public class robDemo {

    /**
     *
     * 打家劫舍： dp[0] =nums[0], dp[1] =max(nums[0],nums[1])
     *  当前房子偷，那就是前一间不偷， 当前房子不偷，就看偷前面的一间的房子： max(dp[i-1],dp[i-2] + nums[i])
     * @param nums
     * @return
     */

    public int rob(int[] nums){
        if (nums.length ==1 ){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0]= nums[0];
        dp[1] =Math.max(nums[0],nums[1]);

        for (int i=2;i<nums.length;i++){
            dp[i] =Math.max(dp[i-1],dp[i-2] + nums[i]);
        }
        // 序列减一操作， 取不到nums.length;
        return  dp[nums.length-1];
    }
}
