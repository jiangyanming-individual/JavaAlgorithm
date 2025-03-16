package LiKoHot100.树;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class maxDepthDemo {


    /**
     * 树的最大深度： 使用层次遍历，即使用队列来实现
     * @return
     */
    public int maxDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        int result= 0;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            // 层次遍历
            while (size>0){
                TreeNode poll = queue.poll();
                if (poll.left!=null){
                    queue.add(poll.left);
                }
                if (poll.right!=null){
                    queue.add(poll.right);
                }
                size--;
            }
            // 每次遍历一层就进行加1的操作
            result++;
        }
        return result;
    }
}
