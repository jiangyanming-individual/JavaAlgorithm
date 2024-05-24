package DpQuestion;

import java.util.Arrays;

/***
 * 01 背包问题 一维数组
 */
public class zero_one_pack_2 {

    public static void main(String[] args) {

        int[] weights = new int[]{1,3,4};
        int[] values = new int[]{15,20,30};

        int packSize=4;
        int[] dp = new int[packSize + 1];

        //初始化
        Arrays.fill(dp,0);

        //遍历：先遍历物品，再遍历背包
        for (int i = 0; i < weights.length; i++) {
            //j 压迫大于等于weights[i]
            for (int j=packSize; j >= weights[i]; j--) {
                //每次遍历物品都要覆盖dp
                dp[j]=Math.max(dp[j],dp[j- weights[i]] + values[i]);
            }
        }
        System.out.println(dp[packSize]);
    }
}
