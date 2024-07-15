package Tree.two;

/**
 * 平衡二叉树：
 */
public class searchBSTDemo {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        return traversal(root, val);
    }

    public TreeNode traversal(TreeNode root, int val) {

        //递归终止条件：
        if (root == null) return null;
        if (root.val == val) return root;
        //单层遍历
        TreeNode result = null;
        if (root.val > val) {
            result = traversal(root.left, val);
        }

        if (root.val < val) {
            result = traversal(root.right, val);
        }
        return result;
    }
}
