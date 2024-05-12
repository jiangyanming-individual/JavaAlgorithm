package DpQuestion;

public class numTreesDemo {

    /**
     * 二叉搜索树
     * @param n
     * @return
     */
    public int numTrees(int n){
        //确定dp的含义：
        int[] dp = new int[n + 1];
        //初始化dp：
        dp[0]=1; //空二搜索叉树为1

        //递推公式： dp[i]+ =dp[j-1] + dp[i-j] //dp[j-1] 是以j为根节点，左子树有多少个节点，dp[i-j] :右子树可以形多少个二叉搜索树

        //确定遍历顺序：
        for (int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i]+=dp[j-1] * dp[i-j]; //二叉搜索树
            }
        }
        //模拟
        return dp[n];
    }
}
