package LiKoHot100.树;

import java.util.LinkedList;
import java.util.Queue;

public class maxPathSumDemo {


    public static void main(String[] args) {




    }
    int maxValue =Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        traversal(root);
        return maxValue;
    }

    public  int traversal(TreeNode root){
        if (root == null){
            return 0;
        }
        // 只取正的
        int left = Math.max(traversal(root.left),0);
        int right =Math.max(traversal(root.right),0);

        int currentVlaue= root.val + left + right;
        maxValue = Math.max(currentVlaue, maxValue);
        // 返回当前最大
        return root.val + Math.max(left, right);
    }



    //构建二叉树
    public static TreeNode buildTree(String input) {
        if (input == null || input.length() == 0) {
            return null;
        }
        String[] values = input.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);

        int i =1;
        while (!queue.isEmpty() && i< values.length){

            TreeNode node = queue.poll();
            if (!values[i].equals("null")){
                node.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(node.left);
            }
            i++;
            // 这里需要判断是否越界， 可能执行i+1 操作回越界：
            if (i<values.length && !values[i].equals("null")){
                node.right =new TreeNode(Integer.parseInt(values[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }
}
