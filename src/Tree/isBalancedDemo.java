package Tree;

import java.text.BreakIterator;

public class isBalancedDemo {

    /**
     * 左右子树的高度之差不能超过1；
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root){
        return getHight(root)  !=-1; //如果不等于-1则为true，反之为false
    }

    //-1表示不是平衡二叉树了
    public int getHight(TreeNode node){

        //递归终止条件
        if (node ==null) return 0;
        int leftHight = getHight(node.left);
        if (leftHight == -1){
            return -1;
        }
        int rightHight = getHight(node.right);
        if (rightHight == -1){
            return -1;
        }
        if (Math.abs(leftHight -rightHight) > 1){
            return -1;
        }
        //单层递归;如果都不满足，根节点+1
        return Math.max(rightHight,leftHight) + 1;
    }
}
