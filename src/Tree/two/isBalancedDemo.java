package Tree.two;

public class isBalancedDemo {

    /**
     * 判断是否为平衡二叉树，左右子树的高度只差不能超过1：
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) >= 0;
    }

    //自底向上遍历，后续遍历求高度
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0; // -1 表示为不平衡, 0 表示正常
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        //符合条件，高度加1；
        return Math.max(left, right) + 1;
    }
}
