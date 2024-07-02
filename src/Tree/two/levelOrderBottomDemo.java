package Tree.two;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrderBottomDemo {


    /**
     * 层次遍历，从底层向上遍历
     * @param root
     * @return
     */
    List<List<Integer>> levelOrderBottom(TreeNode root){
        //使用链表，采用头插法
        LinkedList<List<Integer>> result=new LinkedList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if (root == null){
            return result;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelResult=new ArrayList<>();
            while (size>0){
                TreeNode poll = queue.poll();
                levelResult.add(poll.val);
                if (poll.left!=null){
                    queue.add(poll.left);
                }
                if (poll.right!=null){
                    queue.add(poll.right);
                }
                size--;
            }
            result.addFirst(levelResult);
        }
        return result;
    }
}
