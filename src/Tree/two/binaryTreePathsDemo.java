package Tree.two;

import java.util.ArrayList;
import java.util.List;

public class binaryTreePathsDemo {

    //前序遍历：
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        if (root == null) {
            return result;
        }
        traversal(root, path, result);
        return result;

    }

    public void traversal(TreeNode root, List<Integer> path, List<String> result) {

        //中,先加入最后一个节点，然后再判断其左右子节点是否为空
        path.add(root.val);
        //终止条件
        if (root.left == null && root.right == null) {
            //处理
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                stringBuilder.append(path.get(i)).append("->");
            }
            //添加最后一个
            stringBuilder.append(path.get(path.size() - 1));
            //收集结果
            result.add(stringBuilder.toString());
            return;
        }
        if (root.left != null) {
            traversal(root.left, path, result);
            //回溯：
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            traversal(root.right, path, result);
            path.remove(path.size() - 1);
        }
    }
}

