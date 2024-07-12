package DpQuestion.two;

public class package0_1_Demo {

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagSize = 4;
        System.out.println(getMaxValue(weight, value, bagSize));
        System.out.println(getMaxValueTwo(weight, value, bagSize));
    }

    public static int getMaxValue(int[] weight, int[] value, int bagSize) {
        //定义dp
        int weight_len = weight.length;
        int[][] dp = new int[weight_len][bagSize + 1];

        //初始化dp,第0列全为0；
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        //仅放第一件物品；
        for (int j = 0; j <= bagSize; j++) {
            if (j < weight[0]) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = value[0];
            }

        }

        //遍历，先物品后背包；
        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j]; //不放物品i
                } else {
                    //不放物品i和放入物品i 的最大
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        return dp[weight_len - 1][bagSize];
    }


    public static int getMaxValueTwo(int[] weight, int[] value, int bagSize) {
        //定义dp
        int weight_len = weight.length;
        int[] dp = new int[bagSize + 1];
        //dp[j] =max(dp[j],dp[i-weight[i]] + value[i])


        //从后往前遍历，防止物品多次使用；
        for (int i = 0; i < weight.length; i++) {
            for (int j = bagSize; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[bagSize];
    }

}
