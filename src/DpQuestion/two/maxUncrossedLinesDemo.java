package DpQuestion.two;

public class maxUncrossedLinesDemo {

    /**
     * 也是最长公共子序列：
     * @param nums1
     * @param nums2
     * @return
     */
    public int maxUncrossedLines(int[] nums1,int[] nums2){
        // 定义dp ： 求最长公共子序列：
        int [][] dp=new int[nums1.length+1][nums2.length+1];
        // 初始化：
        for (int i = 0; i < nums1.length; i++) {
            dp[i][0]=0;
        }
        for (int i = 0; i < nums2.length; i++) {
            dp[0][i]=0;
        }
        int res=0;
        for (int i=1;i<=nums1.length;i++){
            for (int j=1;j<=nums2.length;j++){
                if (nums1[i-1] == nums2[j-1]){
                    dp[i][j]=dp[i-1][j-1] +1;
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
                if (dp[i][j] >res) res=dp[i][j];
            }
        }
        return res;
    }
}
