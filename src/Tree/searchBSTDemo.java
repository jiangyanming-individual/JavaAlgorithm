package Tree;

/***
 * 700. 二叉搜索树中的搜索
 * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
 */
public class searchBSTDemo {


    public TreeNode searchBST(TreeNode root,int val){
        if (root == null) return null;
        return traversal(root,val);
    }

    public TreeNode traversal(TreeNode root, int val){
        //循环终止条件
        if (root ==null) return null;
        if (root.val == val) return root;

        //单层递归条件：
        TreeNode result =null;
        if (root.val> val){
            result= traversal(root.left,val); //因为有返回值，直接使用一个TreeNode接住返回值；
        }
        if (root.val<val){
            result=traversal(root.right,val);
        }
        //都不满足返回null;
        return result;
    }
}
