package Tree;


public class lowestCommonAncestorDemo {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //递归终止条件；
        if (root == null || root == p || root == q) return root;
        /**
         * 后序遍历
         */
        //单层递归逻辑：而且需要返回节点；
        TreeNode left = lowestCommonAncestor(root.left, p, q);//左
        TreeNode right = lowestCommonAncestor(root.right, p, q);// 右
        //中：
        if (left!=null && right!=null){
            return root;
        }else if (left!=null && right ==null){
            return left;
        }else if (left == null && right !=null){
            return right;
        }else{
            return null;
        }
    }
}
