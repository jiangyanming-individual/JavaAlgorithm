package DpQuestion.two;

public class isSubsequenceDemo {

    /**
     * 判断子序列： 网格匹配：
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s,String t){

        int [][] dp=new int[s.length()+1][t.length()+1];
        //初始化：
        for (int i=0;i<=s.length();i++){
            dp[i][0]=0;
        }
        for(int j=0;j<=t.length();j++){
            dp[0][j]=0;
        }
        int res=0;
        // 按顺序遍历：
        for (int i=1;i<=s.length();i++){
            for (int j=1;j<=t.length();j++){
                // 判断当前字符是否相等，
                if (s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1] +1;
                }else {
                    dp[i][j] =Math.max(dp[i-1][j],dp[i][j-1]);
                }
                if (dp[i][j] >res) res=dp[i][j];
            }
        }
        return res == s.length();
    }
}
