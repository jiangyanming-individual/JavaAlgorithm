package DpQuestion.two;


public class robDemo3 {


    /**
     * 树形递归，采用后序遍历
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        int[] traversal = traversal(root);

        return Math.max(traversal[0],traversal[1]);
    }
    /**
     * 后序遍历
     * @param root
     * @return
     */
    int[] traversal(TreeNode root){
        int[] dp=new int[2];
        if (root == null) return dp;
        //当前层遍历；
        int[] left = traversal(root.left);
        int[] right = traversal(root.right);

        // 偷当前节点：
         dp[0] = root.val + left[1] + right[1];
         //当前节点不偷：
         dp[1]=Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
         return dp;
    }
}
