package DpQuestion.three;

public class absult {

    public static void main(String[] args) {


        // 先遍历背包再遍历物品

//        for(int j = 0; j <= bagWeight; j++) { // 遍历背包容量
//            for(int i = 0; i < weight.size(); i++) { // 遍历物品
//                if (j - weight[i] >= 0) dp[j] = max(dp[j], dp[j - weight[i]] + value[i]);
//            }
//        }


        // 先遍历物品，再遍历背包
//        for(int i = 0; i < weight.size(); i++) { // 遍历物品

        //物品可以多次放入：
//            for(int j = weight[i]; j <= bagWeight ; j++) { // 遍历背包容量
//                dp[j] = max(dp[j], dp[j - weight[i]] + value[i]);
//
//            }
//        }

    }
}
