package DpQuestion.two;

public class numDistinctDemo {

    public int numDistinct(String s,String t){

        int[][] dp=new int[s.length() + 1][t.length() + 1];
        //初始化：
        for (int i=0;i<=s.length();i++){
            dp[i][0]=1;
        }
        // s为空的话，就不能可能了,j从1开始，  i=0, j=0 默认是可以取到的
        for (int j=1;j<=t.length();j++){
            dp[0][j]=0;
        }
        int res=0;
        for (int i=1;i<=s.length();i++){
            for (int j=1;j<=t.length();j++){
                if (s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1] + dp[i-1][j];
                }else {
                    dp[i][j]=dp[i-1][j];
                }
                if (dp[i][j]>res) res=dp[i][j];
            }
        }
        return res;
    }
}
