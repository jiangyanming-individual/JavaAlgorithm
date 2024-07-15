package Tree.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class isValidBSTDemo {


    List<Integer> result = new ArrayList<>();

    /**
     * 判断是否是平衡二叉树：
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        traversal(root);
        for (int i = 1; i < result.size(); i++) {
            if (result.get(i) < result.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
    public void traversal(TreeNode root) {

        if (root == null) return;
        traversal(root.left);
        result.add(root.val);
        traversal(root.right);
    }
}
