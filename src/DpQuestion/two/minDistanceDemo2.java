package DpQuestion.two;


/**
 * word1 转word2
 */
public class minDistanceDemo2 {

    public int minDistance(String word1,String word2){

        int [][] dp=new int[word1.length()+1][word2.length()+1];
        //初始化：
        for (int i=0;i<=word1.length();i++ ){
            dp[i][0]=i;
        }
        for (int j=0;j<=word2.length();j++) {
            dp[0][j]=j;
        }
        for (int i=1;i<=word1.length();i++){
            for (int j=1;j<=word2.length();j++){
                // 什么都不做：
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    //同时删除出， word1删除或者word2删除：
                    dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1])) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
