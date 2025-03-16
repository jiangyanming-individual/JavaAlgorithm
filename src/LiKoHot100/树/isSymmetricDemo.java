package LiKoHot100.树;

import LiKoHot100.树.TreeNode;

public class isSymmetricDemo {

    public boolean isSymmetric(TreeNode root) {

        if (root == null){
            return true;
        }
       return isTrue(root.left,root.right);
    }

    public boolean isTrue(TreeNode p, TreeNode q){
        if (p == null && q == null){
            return true;
        }

        // 有一个为空节点，直接返回false
        if (p == null || q == null){
            return false;
        }

        if (p.val != q.val){
            return false;
        }

        // 左右节点要对称
        return  isTrue(p.left, q.right) && isTrue(p.right, q.left);
    }
}
