package DpQuestion.three;

import java.lang.reflect.Array;

public class combinationSum4Demo {


    /***
     * 组合总和：题目中说的是排列：
     *
     * (1). 如果求组合数就是外层for循环遍历物品，内层for遍历背包。
     * (2). 如果求排列数就是外层for遍历背包，内层for循环遍历物品。
     *
     * 1. 本题求的排列数，所以先遍历背包再遍历物品， if(j-nums[i]>=0) 才会执行递推公式。
     * 2. 初始化dp, dp[0]=1 仅是为了递推公式：
     * 3. 递推公式：dp[j] =dp[j] + dp[j-nums[i]]
     *
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {

        // 定义dp， 表示装满背包一共有多少种方式
        int[] dp=new int[target+1];

        // 初始化，dp[0]没有意义，
        dp[0]=1;

        //递推公式：dp[j] = dp[j] + dp[j-nums[i]];

        // 本题求的是排列：所以先遍历背包再遍历物品,只有这样才是有顺序的


        // 遍历背包：
        for (int j=1;j<=target;j++ ){
            // 遍历物品
            for (int i=0;i<nums.length;i++) {
                // 只有当背包能放下当前物品才可以成立：
                if (j-nums[i]>=0){
                    dp[j]= dp[j] + dp[j- nums[i]];
                }
            }
        }
        return dp[target];
    }
}
