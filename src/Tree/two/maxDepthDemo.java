package Tree.two;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class maxDepthDemo {

    public int maxDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        int maxDepth=0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size>0){
                TreeNode poll = queue.poll();
                if (poll.left!=null) queue.add(poll.left);
                if (poll.right!=null) queue.add(poll.right);
                size -- ;
            }
            maxDepth++;
        }
        return maxDepth;
    }
}
