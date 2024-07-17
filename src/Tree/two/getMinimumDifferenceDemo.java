package Tree.two;

import java.util.ArrayList;
import java.util.List;

public class getMinimumDifferenceDemo {

    /**
     * 树：
     *
     * @param root
     * @return
     */
    private TreeNode pre;
    private int result = Integer.MIN_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        traversal(root);
        return result;
    }

    public void traversal(TreeNode root) {
        //递归终止：
        if (root == null) return;
        // 左
        traversal(root.left);
        //中
        if (pre != null) {
            result = Math.min(result, Math.abs(root.val - pre.val));
        }
        //更新当前节点：
        pre = root;
        //右
        traversal(root.right);
    }
}
