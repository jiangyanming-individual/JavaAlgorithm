package DpQuestion.two;

import java.util.Scanner;

public class Main {


    /**
     * 爬楼梯，这是按照排列组合的方式：
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] dp = new int[n + 1];
            dp[0] = 1;
            //先背包：
            for (int i = 1; i <= n; i++) {
                //物品从1开始：
                for (int j = 1; j <= m; j++) {
                    if (i - j >= 0) {
                        dp[i] += dp[i - j];
                    }
                }
            }
            System.out.println(dp[n]);
        }
    }
}
