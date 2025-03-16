package DpQuestion.three;

public class robDemo {


    /**
     * 打家劫舍：
     * 1. 初始化：dp.size == nums.length,   dp[0]=nums[0], dp[1] =max(nums[0],nums[1]);
     * 2. 当前房子偷 （那前一个房子肯定不会被偷）和 不偷(那就看dp[i-1])取最大的值
     * 3. 递推公式： dp[i] =max(dp[i-1],dp[i-2] +nums[i])
     * @param nums
     * @return
     */
    public int rob(int[] nums) {

        // 定义dp[i]，表示前房子所能偷到的最大金额。=
        // 数组不存在的直接为0；
        if (nums.length == 0) return 0;
        if (nums.length ==1) return nums[0];

        // dp的长度是nums.length
        int [] dp=new int[nums.length];
        //初始化：
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);

        //遍历：i从2开始
        for (int i=2;i<nums.length;i++){
            // 当前房子偷 （那前一个房子肯定不会被偷）和 不偷(那就看dp[i-1])取最大的值
            dp[i] =Math.max(dp[i-1], dp[i-2]  + nums[i]);
        }
        return  dp[nums.length-1];
    }
}
