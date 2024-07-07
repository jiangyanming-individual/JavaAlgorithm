package Tree.two;

public class countNodesDemo {

    //层次遍历：
//    public int countNodes(TreeNode root) {
//
//        if (root == null) {
//            return 0;
//        }
//        Queue<TreeNode> queue = new LinkedList<>();
//        int count = 0;
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            count += size;
//            while (size > 0) {
//                TreeNode poll = queue.poll();
//                if (poll.left != null) queue.add(poll.left);
//                if (poll.right != null) queue.add(poll.right);
//                size--;
//            }
//        }
//        return count;
//    }

    public int countNodes(TreeNode root) {
        return traversal(root);
    }

    public int traversal(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int left = traversal(root.left);
        int right = traversal(root.right);

        // 加1 是要处理当前节点：
        return left + right + 1;
    }

}
