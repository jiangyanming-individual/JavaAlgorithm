package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class minDepthDemo {

    public int minDepth(TreeNode root){

        if (root ==null) return 0;
        Queue<TreeNode> queue= new LinkedList();
        int minDepth=0;
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            minDepth++; //每一层都加1；
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null){
                    return minDepth; //当左右节点都为空，才算是达到了叶子节点；直接返回
                }
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
            }
        }
        return minDepth;
    }
}
