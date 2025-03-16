package DpQuestion.three;

import java.util.Scanner;

public class numTreesDemo {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = numTrees(n);
        System.out.println(i);
    }
    /**
     * 不同的二叉搜索树
     *
     * 1. dp: 表示能够组成的不同二叉搜索树的个数：
     * 2. 递推公式： dp[i] += dp[以j为头结点左子树节点数量] (j-1)* dp[以j为头结点右子树节点数量] (i-j)
     * 3. 返回dp[n],
     * @param n
     * @return
     */
    public static int numTrees(int n){

        int[] dp=new int[n+1];
        //初始化：空的二叉树也有为1
        dp[0]=1;
        for (int i=1;i<=n;i++){
            for (int j=1;j<=i;j++){
                // 以j为头结点： (左子树元素的个数 * 右子树的元素个数)
                dp[i]+=dp[j-1] *  dp[i- j]; //j-1表示仅能有j-1个数中去取， i-j：表示剩下的数。
            }
        }
        return dp[n];
    }
}
