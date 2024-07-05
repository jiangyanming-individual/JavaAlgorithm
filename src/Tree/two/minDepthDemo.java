package Tree.two;

import java.util.LinkedList;
import java.util.Queue;

public class minDepthDemo {

    public int minDepth(TreeNode root){
        if (root == null) return 0;
        int minDepth=0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size>0){
                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right== null){
                    return minDepth + 1; //直接return minDepthDemo +1
                }
                if (poll.left!=null)queue.add(poll.left);
                if (poll.right!=null) queue.add(poll.right);

                size--;
            }
            minDepth++;
        }
        return minDepth;
    }
}
