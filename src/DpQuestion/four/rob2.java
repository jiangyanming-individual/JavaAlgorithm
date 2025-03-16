package DpQuestion.four;

public class rob2 {


    /**
     * 打家劫舍2
     * 1. 首部考虑，尾部不考虑
     * 2. 首部不考虑，尾部考虑
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 0) return 0 ;
        if (nums.length == 1) return nums[0];

        if (nums.length == 2) return  Math.max(nums[0],nums[1]);

        int max1 = getMax(nums, 0, nums.length - 2);
        int max2 = getMax(nums, 1, nums.length - 1);
        // 比较两种情况的最大值
        return Math.max(max1,max2);
    }

    public int getMax(int[] nums, int start,int end){
        //定义dp
        int [] dp=new int[nums.length];
        dp[start]=nums[start];
        dp[start +1] =Math.max(nums[start],nums[start +1]);

        for (int i=start+2; i<=end;i++ ){
            // 偷当前的屋子和不偷当前的屋子
            dp[i]= Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        // 返回dp[end]
        return dp[end];
    }
}
