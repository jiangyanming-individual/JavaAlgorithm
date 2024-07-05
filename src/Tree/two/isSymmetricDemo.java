package Tree.two;

public class isSymmetricDemo {

    public boolean isSymmetric(TreeNode root) {
        //比较左右子树，不是根节点
        return traversal(root.left, root.right);
    }

    public boolean traversal(TreeNode left, TreeNode right) {
        //返回条件
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right == null) {
            return false;
        }
        if (left == null && right != null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }
        //根节点不做处理

        //左
        boolean traversal1 = traversal(left.left, right.right);
        //右
        boolean traversal2 = traversal(left.right, right.left);
        return traversal1 && traversal2;
    }
}
