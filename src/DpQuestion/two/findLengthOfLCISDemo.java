package DpQuestion.two;

public class findLengthOfLCISDemo {


    /**
     * 最长连续递增子序列：
     *
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {

        // 定义数组：
        int[] dp=new int[nums.length];
        // 初始化dp, 最少得长度也应该是1；
        for (int i = 0; i < nums.length; i++) {
            dp[i]=1;
        }
        int result=1;
        for (int i=1;i<nums.length;i++){
            if (nums[i]>nums[i-1]){
                dp[i]=dp[i-1] + 1;
            }
            // 更新result
            if (dp[i] > result) result=dp[i];
        }
        return result;
    }
}
