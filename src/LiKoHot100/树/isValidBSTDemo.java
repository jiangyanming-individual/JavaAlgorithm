package LiKoHot100.树;

import java.util.ArrayList;
import java.util.List;

public class isValidBSTDemo {


    /**
     * 判断是否是平衡二叉树： 递归的方法 + 使用一个列表进行存储值；
     * @param root
     * @return
     */

    List<Integer> res= new ArrayList<Integer>();
    public boolean isValidBST(TreeNode root){

        if (root == null){
            return true;
        }
        traversal(root);
        // 对结果集进行遍历比较的操作：
        for (int i = 1; i < res.size(); i++) {
            if (res.get(i)<= res.get(i-1)){
                return false;
            }
        }
        return true;
    }

    public void traversal(TreeNode root ){
        if (root == null){
            return;
        }

        // 中序遍历
        traversal(root.left);
        res.add(root.val);
        traversal(root.right);
    }

    public boolean isValidBST2(TreeNode root){
        return isTrue(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isTrue(TreeNode root, long min, long max){
        if (root == null){
            return true;
        }
        // 如果节点不在区间就直接返回false， 而且严格要求左节点必须小于中间节点。
        if (root.val<= min || root.val>=max){
            return false;
        }

        // 左右节点都必须要在范围区间内
        return isTrue(root.left, min, root.val) && isTrue(root.right,root.val, max);
    }
}
