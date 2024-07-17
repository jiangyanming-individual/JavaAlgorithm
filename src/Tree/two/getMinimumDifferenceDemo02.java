package Tree.two;

import java.util.ArrayList;
import java.util.List;

public class getMinimumDifferenceDemo02 {

    /**
     * 树：
     *
     * @param root
     * @return
     */
    List<Integer> result = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        traversal(root);
        int min = Integer.MAX_VALUE;
        //比较获得最小的值
        for (int i = 1; i < result.size(); i++) {
            min = Math.min(min, result.get(i) - result.get(i - 1));
        }
        return min;
    }

    //先遍历平衡二叉树：
    public void traversal(TreeNode root) {
        //递归终止：
        if (root == null) return;
        // 左
        traversal(root.left);
        //中
        result.add(root.val);
        traversal(root.right);
    }
}
