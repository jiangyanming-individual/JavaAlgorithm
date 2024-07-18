package DpQuestion.two;

public class combinationSum4Demo {


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        int target = 4;
        combinationSum4(nums, target);
    }

    /**
     * 组合数
     *
     * @param nums
     * @param target
     * @return
     */
    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        //初始化：
        dp[0] = 1;
        //求排列数，需要先遍历背包,先遍历物品不会出现{1,5} {5,1} 的这种情况
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                    System.out.println("dp[i]:" + dp[i]);
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println("dp: " + dp[i]);
        }
        return dp[target];
    }
}
