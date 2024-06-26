package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class averageOfLevelsDemo {


    public List<Double> averageOfLevels(TreeNode root){
        ArrayList<Double> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root!=null) queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            double sum=0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum+=node.val;
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
            }
            list.add( sum /size);
        }
        return list;
    }

}
