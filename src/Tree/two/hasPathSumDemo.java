package Tree.two;

public class hasPathSumDemo {


    public boolean hasPathSum(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        return traversal(root, target - root.val);
    }

    public boolean traversal(TreeNode root, int count) {

        if (root.left == null && root.right == null && count == 0) return true;
        if (root.left == null && root.right == null && count != 0) return false;


        //符合条件的
        if (root.left != null) {
            count = count - root.left.val;
            if (traversal(root.left, count)) return true;
            count += root.left.val;
        }

        if (root.right != null) {
            count = count - root.right.val;
            if (traversal(root.right, count)) return true;
            count += root.right.val;
        }
        return false;
    }
}
