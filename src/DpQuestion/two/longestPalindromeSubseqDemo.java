package DpQuestion.two;

public class longestPalindromeSubseqDemo {


    /**
     * 最长回文子序列： 可以是不连续的，可以对某个中间的元素进行删除操作
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s){
        if (s.isEmpty() || s == null) return 0;
        char[] chars = s.toCharArray();
        // 定义dp
        int[][] dp=new int[chars.length][chars.length];
        // 初始dp, 当i和 j都指向同一个元素时，回文子序列长度为1；
        for (int i=0;i<chars.length;i++){
            dp[i][i] =1;
        }
        // 从下往上遍历
        for (int i=chars.length-1;i>=0;i--){
            // 因为j>=i, 而且i == j的情况已经初始化过了
            for (int j=i+1;j<chars.length;j++){
                if (chars[i] == chars[j]){
                  dp[i][j] =dp[i+1][j-1] + 2;
                }else {
                    //i +1 或者j-1的情况才能形成回文；
                    dp[i][j]=Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }
        //最右上方取结果
        return dp[0][chars.length-1];
    }

}
