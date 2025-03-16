package DpQuestion.three;

public class findMaxFormDemo {

    /**
     *
     * 一和零：滚动数组， 背包倒序遍历保证每个物品只被添加了一次
     * 1. dp[m+1][n+1] 表示能得到的最长的子集
     * 2. 初始化dp[i]=0, 全部为0；
     * 3. 先遍历每个字符串，统计个数，然后遍历背包，计算出加入当前字符所能得到的最长的子集。
     * 4. 递推公式：dp[i][j] =Max(dp[i][j],dp[i-zeroNums][j- oneNums] +1); 加上当前字符和不加上当前字符。
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {

        //dp表示能得到子集的最大的长度,
        int [][] dp=new int[m+1][n+1];
        // 背包容量为 m，n;
        // 初始化都为0；

        // 遍历物品
        for (String str : strs) {
            int oneNums=0;
            int zeroNums=0;
            // 统计0和1 的个数
            for (int i=0;i<str.length();i++){
                if (str.charAt(i) == '0'){
                    zeroNums++;
                }else {
                    oneNums++;
                }
            }
            // 遍历背包,倒序遍历：
            for (int i=m;i>=zeroNums;i--){
                for (int j=n;j>=oneNums;j--){
                    //递推公式：放当前字符和不放当前字符串：
                    dp[i][j]= Math.max(dp[i][j], dp[i-zeroNums][j-oneNums]+1);
                }
            }
        }

        // 返回结果
        return dp[m][n];
    }
}
