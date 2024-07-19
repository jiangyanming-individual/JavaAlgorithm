package DpQuestion.two;

public class numSquaresDemo {

    /**
     * 完全平方和：最少：
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {


        int max = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = max;
        }
        //先物品，在背包：
//        for (int i = 1; i * i <= n; i++) {
//            for (int j = i * i; j <= n; j++) {
//                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
//            }
//        }

        //先背包在物品：
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }

}
