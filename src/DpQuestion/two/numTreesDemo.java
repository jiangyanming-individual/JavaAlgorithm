package DpQuestion.two;

public class numTreesDemo {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // 以j 为头结点，左右子树的个数相乘
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
