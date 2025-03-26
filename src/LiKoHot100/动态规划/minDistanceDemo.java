package LiKoHot100.动态规划;

import java.util.Map;

public class minDistanceDemo {


    /**
     * 编辑距离：
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1,String word2){
        int[][] dp=new int[word1.length()+1][word2.length()+1];

        // 初始化： 需要修改多少字符
        for (int i=0;i<=word1.length();i++){
            dp[i][0] =i;
        }

        for (int j=0;j<=word2.length();j++){
            dp[0][j]= j;
        }

        // 遍历
        for (int i=1;i<=word1.length();i++){
            for (int j=1;j<=word2.length();j++){
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] =dp[i-1][j-1];
                }else {
                    // word1操作一次；word2操作一次， word1和word2同时操作
                    dp[i][j]= Math.min(dp[i-1][j], Math.min(dp[i][j-1],dp[i-1][j-1])) +1;
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
