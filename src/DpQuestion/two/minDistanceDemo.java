package DpQuestion.two;

public class minDistanceDemo {


    /**
     * 两个字符串排匹配: 两个字符串是都可以删除了
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String  word1, String word2){


        int [][] dp=new int[word1.length()+1][word2.length()+1];
        //初始化dp
        for (int i=0;i<=word1.length();i++){
            dp[i][0]=i;
        }

        for (int j=0;j<=word2.length();j++){
            dp[0][j]=j;
        }
        int res=Integer.MIN_VALUE;

        for (int i=1;i<=word1.length();i++ ){
            for (int j=1;j<=word2.length();j++){
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]; // 两个都不用删除；
                }else {
                    //两个同时删除和 word1、word2分别删除
                    dp[i][j]=Math.min(dp[i-1][j-1]+ 2,Math.min(dp[i-1][j],dp[i][j-1]) + 1);
                }
                if (dp[i][j]> res) res =dp[i][j];
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
