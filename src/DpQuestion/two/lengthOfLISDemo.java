package DpQuestion.two;

import java.util.Arrays;

public class lengthOfLISDemo {

    public int lengthOfIS(int[] nums){

        if (nums.length == 1) return nums.length;
        int result=1;
        // 定义dp
        int[] dp=new int[nums.length];
        // 初始化：
        Arrays.fill(dp,1);
        // 状态转移方程： dp[i] = max(dp[i],dp[j] +1)
        for (int i = 1; i < nums.length; i++) {
            for (int j=0;j<i;j++){
                //如果当前节点的值大于[0,i-1]中的值， dp ++
                if (nums[i]> nums[j]){
                    // dp[j] 会一直更新
                    dp[i]=Math.max(dp[i],dp[j] + 1);
                }
                if (dp[i] > result) result=dp[i];
            }
        }
        return result;
    }
}
