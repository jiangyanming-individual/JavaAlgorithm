package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class countNodesDemo {


    public int countNodes(TreeNode root){

        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return 0;
        queue.add(root);
        int sumCount=0;
        while (!queue.isEmpty()){
            int size = queue.size();
            sumCount+=size;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
            }

        }
        return sumCount;
    }
}
