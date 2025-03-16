package DpQuestion.three;

public class rob2 {


    /**
     * 打家劫舍2，
     * (1)要首不要尾部 (2) 要尾部不要首部
     * (2) 递推公式和打家劫舍1 是一致的， dp[i]=max(dp[i-2] + nums[i],dp[i-1]);
     *
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        // 特殊情况
        if (nums.length == 0) return 0;
        if (nums.length ==1) return nums[0];
        if (nums.length ==2) return Math.max(nums[0],nums[1]);
        //要首部，不要尾部
        int max1 = getMax(nums, 0, nums.length - 2);
        // 要尾部，不要首部
        int max2 = getMax(nums, 1, nums.length-1);
        //返回两者的最大值：
        return Math.max(max1,max2);
    }
    public int getMax(int[] nums,int start,int end){

        // 初始化
        int [] dp=new int[nums.length];
        if (start == end) return  nums[start];
        // 初始化：dp[0], dp[1]
        dp[start]=nums[start];
        dp[start +1] =Math.max(nums[start],nums[start +1]);
        for (int i=start+2;i<=end;i++){
            // 递推公式还是一样的，偷当前物品和不偷当前物品：
            dp[i]=Math.max(dp[i-2] + nums[i],dp[i-1]);
        }
        // 返回结果：
        return dp[end];
    }

}
