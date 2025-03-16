package LiKoHot100.数组;

public class maxSubArrayDemo {

    /**
     * 最大子数组的和: 使用动态规划来实现：
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {

        int maxSum =nums[0];
        int pre =0;
        for (int i=0;i<nums.length;i++){

            // pre =max(pre + x, x)
            pre = Math.max(pre+ nums[i], nums[i]);
            maxSum = Math.max(pre, maxSum);
        }
        return maxSum;

    }
}
