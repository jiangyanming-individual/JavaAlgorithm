package LiKoHot100.树;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class rightSideViewDemo {


    /**
     * 右视图: 使用层次遍历 : 队列遍历
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root){

        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=1;i<=size;i++){
                TreeNode poll = queue.poll();
                if (i == size){
                    res.add(poll.val);
                }

                if (poll.left!=null){
                    queue.add(poll.left);
                }

                if (poll.right!=null){
                    queue.add(poll.right);
                }
            }
        }
        return res;
    }
}
