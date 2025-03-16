package LiKoHot100.树;

public class invertTreeDemo2 {



    public  TreeNode invertTree(TreeNode root){
        return reverseNode(root);
    }

    public TreeNode reverseNode(TreeNode root){
        // 递归终止条件
        if (root == null){
            return root;
        }

        // 中
        TreeNode tempNode = new TreeNode();
        tempNode =root.left;
        root.left= root.right;
        root.right =tempNode;

        // 左
        reverseNode(root.left);
        // 右
        reverseNode(root.right);
        // 返回递归结果:
        return root;
    }

}
