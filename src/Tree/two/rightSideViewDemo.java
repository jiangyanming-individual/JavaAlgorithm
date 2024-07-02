package Tree.two;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class rightSideViewDemo {

    /**
     * 右侧视图
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root){
        List<Integer> result=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if (root == null){
            return result;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 1; i <= size; i++) {
                TreeNode poll = queue.poll();
                if (i == size){
                    result.add(poll.val);
                }
                if (poll.left!=null) queue.add(poll.left);
                if (poll.right!=null) queue.add(poll.right);
            }
        }
        return result;
    }
}
