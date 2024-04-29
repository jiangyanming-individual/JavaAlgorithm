package Tree;


/**
 * 二叉搜索树的公共祖先：
 */
public class lowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //递归终止条件：
        if (root == null) return root;

        //单层递归条件
        //中间节点不处理
        //左 cur.var> p.var  cur.var > q.var 往左子树查找
        if (root.val > p.val && root.val > q.val){
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            if (left!=null){
                return left; //返回节点；
            }
        }
        // 右 cur.var < p.var  cur.var < q.var 往右子树查找
        if (root.val< p.val && root.val< q.val){
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (right!=null){
                return right; //返回节点；
            }
        }
        return root; //返回当前节点： 满足在[p,q]这个区间；
    }
}
