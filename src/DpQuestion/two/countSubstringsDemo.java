package DpQuestion.two;

public class countSubstringsDemo {

    /**
     * 回文子串
     * @param s
     * @return
     */
    public int countSubstrings(String s){

        if (s == null || s.isEmpty()) return 0;
        char[] charArray = s.toCharArray();
        boolean[][] dp = new boolean[charArray.length][charArray.length];
        int result=0;
        // i是从下往上
        for (int i=charArray.length-1;i>=0;i--){
            // j>=i的
            for (int j=i;j<charArray.length;j++){
                if (charArray[i] == charArray[j]){
                    if (j-i<=1){
                        result++;
                        dp[i][j]=true;
                    }else if(dp[i+1][j-1]){
                        result++;
                        dp[i][j]=true;
                    }
                }
            }
        }
        return result;
    }
}
