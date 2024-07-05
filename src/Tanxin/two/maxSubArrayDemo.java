package Tanxin.two;

public class maxSubArrayDemo {

    /**
     * 最大子序列之和
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }
        int sum = 0;
        int max_sum_value = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            //比较最大值：
            max_sum_value = Math.max(sum, max_sum_value);
            if (sum < 0) {
                //重头开始
                sum = 0;
            }
        }
        return max_sum_value;
    }
}
