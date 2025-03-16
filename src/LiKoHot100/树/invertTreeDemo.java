package LiKoHot100.树;

public class invertTreeDemo {


    /**
     * 翻转二叉树：使用递归的方法进行实现。
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root){
        return traversal(root);
    }

    public TreeNode traversal(TreeNode root){

        // 递归终止条件
        if (root == null){
            return root;
        }
        // 翻转的根节点:
        TreeNode tempNode = new TreeNode();
        tempNode =root.left;
        root.left =root.right;
        root.right =tempNode;

        // 左
        traversal(root.left);
        // 右
        traversal(root.right);

        return root;
    }
}
