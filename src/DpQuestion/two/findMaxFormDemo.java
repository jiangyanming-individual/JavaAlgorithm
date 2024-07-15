package DpQuestion.two;

public class findMaxFormDemo {

    public int findMaxFrom(String[] strs, int m, int n) {
        //遍历背包和物品：
        //背包
        int[][] dp = new int[m + 1][n + 1];
        //先遍历物品：
        for (String str : strs) {
            int zeroNums = 0;
            int oneNums = 0;
            for (char c : str.toCharArray()) {

                if (c == '0' ) {
                    zeroNums++;
                } else {
                    oneNums++;
                }
            }
            //遍历背包
            for (int i = m; i >= zeroNums; i--) {
                for (int j = n; j >= oneNums; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNums][j - oneNums] + 1);
                }
            }

        }
        //返回结果：
        return dp[m][n];
    }
}
