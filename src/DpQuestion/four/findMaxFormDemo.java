package DpQuestion.four;

public class findMaxFormDemo {


    /***
     *
     * 一和零
     *
     * 1.
     *
     *
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {

        // 定义dp, 表示m个0和n个1最多长的长度
        int [][] dp=new int[m+1][n+1];

        // 初始化，dp 滚动数组从后往前遍历。初始化为0；

        // 遍历：先遍历物品，再遍历背包
        for (String str : strs) {
            // 统计一个字符

            int oneNums=0;
            int zeroNums=0;
            for (int i=0;i<str.length();i++){

                if (str.charAt(i) == '0'){
                    zeroNums++;
                }else {
                    oneNums++;
                }
            }

            // 遍历背包， 而且必须要有大于zeroNums的容量
            for (int i=m;i>=zeroNums;i--){
                for (int j=n;j>=oneNums;j--){
                    // 递推公式：放当前字符串和不放当前字符串所能得到的最大长度
                    dp[i][j]=Math.max(dp[i][j], dp[i-zeroNums][j-oneNums] +1);
                }
            }
        }
        return dp[m][n];
    }
}
