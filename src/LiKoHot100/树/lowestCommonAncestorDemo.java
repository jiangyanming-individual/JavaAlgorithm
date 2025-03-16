package LiKoHot100.树;

public class lowestCommonAncestorDemo {


    /**
     * 二叉树的最近公共祖先：使用递归的方法。 递归终止条件：
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if (root == null || root == q || root == p){
            return root;
        }
        TreeNode left =lowestCommonAncestor(root.left, p,q);
        TreeNode right =lowestCommonAncestor(root.right,p,q);

        if (left!=null && right!=null){
            return root;
        }
        // 如果左节点不为空的话，返回左节点。如果右节点不为空的话，返回右节点。
        return left!=null ? left : right;
    }
}
