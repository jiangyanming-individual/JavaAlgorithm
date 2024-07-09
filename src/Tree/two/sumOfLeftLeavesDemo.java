package Tree.two;

import java.util.LinkedList;
import java.util.Queue;

public class sumOfLeftLeavesDemo {

//    int sum = 0;
//    public int sumOfLeftLeaves(TreeNode root) {
//        traversal(root);
//        return sum;
//    }
//    //根据父节点来判断：
//    public void traversal(TreeNode root) {
//
//        if (root == null){
//            return;
//        }
//        //本节点的左节点不为空，而且左节点的左右子节点都为空
//        if (root.left!=null && root.left.left== null && root.left.right == null){
//            sum+=root.left.val;
//        }
//        traversal(root.left);
//        traversal(root.right);
//    }


    //层次遍历
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int sum = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.add(poll.left);
                    //累加和
                    if (poll.left.left == null && poll.left.right == null) {
                        sum += poll.left.val;
                    }
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                size--;
            }
        }
        return sum;
    }

}
