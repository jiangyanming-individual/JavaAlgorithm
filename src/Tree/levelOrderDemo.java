package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrderDemo {

    public List<List<Integer>> levelOrder(TreeNode root){

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>(); //队列

        if (root!=null) queue.add(root);
        while (!queue.isEmpty()){
            //队列的长度；
            int size = queue.size();
            List<Integer> tempList = new ArrayList<>();
            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                tempList.add(node.val);
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
            }
            result.add(tempList); //加入每一层的结果集
        }

        return result;
    }
}
