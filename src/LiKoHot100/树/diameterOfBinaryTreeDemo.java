package LiKoHot100.树;

import java.util.Map;

public class diameterOfBinaryTreeDemo {

    /**
     * 二叉树的直径：先计算左右子树最大深度
     * （1）计算节点的深度， max(left, right)+ 1
     * （2）设置一个ans 用于存储最长的路径：
     * @return
     */
    int ans;
    public int diameterOfBinaryTree(TreeNode root){
        int ans =1;
        depth(root);
        return ans -1;
    }

    public int depth(TreeNode node){
        if (node == null){
            return 0;
        }
        int L= depth(node.left);
        int R= depth(node.right);
        // （最长路径长度）为 L + R + 1（左子树深度 + 右子树深度 + 当前节点）。
        ans =Math.max(ans, L + R +1);
        //统计节点的深度：
        return Math.max(L,R) + 1;
    }

}
