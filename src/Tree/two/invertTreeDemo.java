package Tree.two;

public class invertTreeDemo {

    public TreeNode invertTree(TreeNode root) {
        return traversal(root);
    }

    public TreeNode traversal(TreeNode root) {

        if (root == null) {
            return root;
        }
        //根
        TreeNode node = new TreeNode();
        node = root.left;
        root.left = root.right;
        root.right = node;
        //左
        traversal(root.left);
        //右
        traversal(root.right);
        return root;
    }
}
