package DpQuestion.two;

/**
 * 最长公共子序列： 与最长重复子数组是一样的解法：
 */
public class longestCommonSubsequenceDemo {

    public int longestCommonSubsequence(String text1,String text2){

        int[][] dp=new int[text1.length()+1][text2.length()+1];
        //初始化：
        for (int i = 0; i < text1.length(); i++) {
            dp[i][0]=0;
        }
        for (int i = 0; i < text2.length(); i++) {
            dp[0][i]=0;
        }
        int result=0;
        //可以取到等号：
        for (int i = 1; i <=text1.length(); i++) {
            for (int j = 1; j <=text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 如果不相等, 进行交叉对比
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                if (dp[i][j] > result) result = dp[i][j];
            }
        }
        return result;
    }
}
