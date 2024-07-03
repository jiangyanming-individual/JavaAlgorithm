package Tree.two;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class largestValuesDemo {


    public List<Integer> largestValues(TreeNode root){
        List<Integer> result=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if (root == null){
            return result;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            int maxValue=Integer.MIN_VALUE;
            while (size>0){
                TreeNode poll = queue.poll();
                if (maxValue<poll.val){
                    maxValue= poll.val;
                }
                if (poll.left!=null) queue.add(poll.left);
                if (poll.right!=null) queue.add(poll.right);
                size--;
            }
            result.add(maxValue);
        }
        return result;
    }
}
