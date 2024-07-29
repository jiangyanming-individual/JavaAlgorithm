package Tree.two;

import java.util.ArrayList;
import java.util.List;

public class getMinimumDifferenceDemo {


    /**
     * 二叉搜索树中最小绝对值之差
     */
    List<Integer> result = new ArrayList<>();

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        int min = Integer.MAX_VALUE;
        traversal(root);
        //result是升序的数组
        for (int i = 1; i < result.size(); i++) {
            min = Math.min(min, result.get(i) - result.get(i - 1));
        }
        return min;
    }

    /**
     * 中序遍历：
     *
     * @param root
     */
    public void traversal(TreeNode root) {

        if (root == null) return;
        traversal(root.left);
        result.add(root.val);
        traversal(root.right);
    }
}
