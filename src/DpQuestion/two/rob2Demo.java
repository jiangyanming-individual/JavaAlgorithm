package DpQuestion.two;

public class rob2Demo {

    /**
     * 打家劫舍2，形成一个环形：
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {

        if (nums.length == 0 || nums == null) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        //打家劫舍1
        int result1 = rangeNum(nums, 0, nums.length - 2); //去尾部
        int result2 = rangeNum(nums, 1, nums.length - 1); // 去头部
        return Math.max(result1, result2);
    }

    public int rangeNum(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        if (start == end) return nums[start];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        //偷i 和不偷i的区别
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        //end是可以取到的：
        return dp[end];
    }
}
