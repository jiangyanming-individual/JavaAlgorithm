package Tree;

import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.List;

public class hasPathSumDemo {


    /**
     * 递归和回溯 + 前序遍历
     * @param root
     * @param target
     * @return
     */
    public boolean hasPathSum(TreeNode root, int target){
        if (root ==null){
            return false;
        }
        return traversal(root, target - root.val);
    }
    public boolean traversal(TreeNode node,int count){

        //递归终止条件；
        if (node.left == null && node.right == null && count == 0) return true;
        if (node.left == null && node.right == null) return false;

        if (node.left!=null){
            count -=node.left.val;
            if (traversal(node.left,count)) return true; //判断结是否为true；
            count+=node.left.val; //回溯；
        }
        if (node.right!=null){
            count-=node.right.val;
            if (traversal(node.right,count)) return true;
            count += node.right.val;
        }
        //最后返回false;
        return false;
    }
}
