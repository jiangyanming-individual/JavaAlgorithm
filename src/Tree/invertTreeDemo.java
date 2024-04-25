package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class invertTreeDemo {

    public TreeNode invertTree(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList();

        if (root == null) return root;
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                swap(node);
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
            }

        }
        return root;
    }

    public void swap(TreeNode node){

        TreeNode tempNode;
        tempNode=node.left;
        node.left=node.right;
        node.right=tempNode;
    }
}
