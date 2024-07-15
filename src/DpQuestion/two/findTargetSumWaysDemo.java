package DpQuestion.two;

import java.util.Arrays;

public class findTargetSumWaysDemo {

    /**
     * 目标和
     *
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {

        int sum = Arrays.stream(nums).sum();

        if ((sum + target) % 2 == 1) return 0;
        if (Math.abs(target) > sum) return 0;
        int bagSize = (sum + target) / 2;

        int[] dp = new int[bagSize + 1];
        dp[0] = 1;
        //递归公式：累加和 dp[j]+=dp[j-num[i]]
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagSize; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[bagSize];
    }
}
