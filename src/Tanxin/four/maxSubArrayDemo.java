package Tanxin.four;

public class maxSubArrayDemo {

    /**
     * 最大子序列之和
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {

        int curSum=nums[0];
        int maxSum=nums[0];
        // 相当于是打擂台
        for (int i=1;i<nums.length;i++) {

            if (curSum>0){
                curSum+=nums[i];
            }else {
                // 重新计数
                curSum=nums[i];
            }
            if (curSum>maxSum){
                maxSum=curSum;
            }
        }
        return maxSum;
    }
}
