package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class largestValuesDemo {

    public List<Integer> largestValues(TreeNode root){

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root!=null)  queue.add(root);
        while (!queue.isEmpty()){

            int size = queue.size();
            int Max_value=Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                Max_value=node.val> Max_value ? node.val : Max_value;

                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
            }
            list.add(Max_value);
        }

        return list;
    }
}
