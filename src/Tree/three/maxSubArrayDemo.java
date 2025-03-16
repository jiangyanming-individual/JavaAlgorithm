package Tree.three;

public class maxSubArrayDemo {


    /**
     * 最子数组之和，求的是连续的子数组的最大和。
     *
     * 1. 贪心策略，判断当前curSum是否大于0， 如果不是就需要从当前开始从新加。
     * 2 使用动态规划的思想：
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums.length==1) return nums[0];
//        int maxSum=nums[0];
//        int curSum=nums[0];
//        for (int i=1;i< nums.length;i++) {
//            if (curSum>0){
//                // 和上一个加入大于0，
//                curSum+=nums[i];
//            }else {
//                // 和上一个相加为负数，从新开始
//                curSum=nums[i];
//            }
//            maxSum=Math.max(maxSum,curSum);
//        }
//        return maxSum;

        //在下标为i 的元素之间， 相加的最大值为dp[i]
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        int res=nums[0];
        for (int i=1;i< nums.length;i++) {

            dp[i]=Math.max(dp[i-1] + nums[i], nums[i]);// 和当前元素比较；
            if (dp[i]>res){
                res=dp[i];
            }
        }
        return res;
    }
}
