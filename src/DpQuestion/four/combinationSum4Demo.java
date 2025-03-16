package DpQuestion.four;

public class combinationSum4Demo {


    /**
     * 组合总数：这里求的是排列数
     *
     *
     * @param nums
     * @param target
     * @return
     */

    public int combinationSum4(int[] nums, int target) {


        // 定义dp
        int [] dp=new int[target +1];

        // 初始化： dp[0]没有意义
        dp[0]=1;

        // 先遍历背包再遍历物品：
        for (int j=0;j<=target;j++){
            // 这样的话，会出现（1,2） (2,1)的情况
            for (int i=0;i<nums.length;i++){
                if (j- nums[i] >=0){
                    dp[j] = dp[j] + dp[j - nums[i]];
                }
            }
        }
        //返回结果
        return dp[target];
    }
}
