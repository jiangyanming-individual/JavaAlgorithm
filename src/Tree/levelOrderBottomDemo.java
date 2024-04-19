package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrderBottomDemo {

    public List<List<Integer>> levelOrderBottom(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root!=null) queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                tempList.add(node.val); //每次弹出一个元素，加入到tempList中
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            result.add(0,tempList);
        }
        return result;
    }
}
