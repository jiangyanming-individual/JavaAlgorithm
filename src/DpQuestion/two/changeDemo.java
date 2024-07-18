package DpQuestion.two;

import java.util.Arrays;

public class changeDemo {

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = new int[]{1, 2, 5};
        change(amount, coins);
    }

    public static int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];
        int[] dp2 = new int[amount + 1];
        dp[0] = 1;// 初始化为1；
        dp2[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println("dp1：" + dp[i]);
        }

//        for (int i = 0; i <= amount; i++) {
//            for (int j = 0; j < coins.length; j++) {
//                if (i - coins[j] >= 0) {
//                    dp2[i] += dp2[i - coins[j]];
//                }
//            }
//        }
//        for (int i = 0; i < dp.length; i++) {
//            System.out.println("dp2：" + dp2[i]);
//        }

        return 0;
    }
}
