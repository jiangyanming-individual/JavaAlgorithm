package LiKoHot100.树;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class maxPathSumDemo2 {

    static int maxValue= Integer.MIN_VALUE;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] values = s.split(",");
        Queue<TreeNode> queue=new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.offer(root);
        int i=1;
        while (!queue.isEmpty() && i<values.length){

            TreeNode currentNode = queue.poll();
            if (!values[i].equals("null")){
                currentNode.left= new TreeNode(Integer.parseInt(values[i]));
                queue.offer(currentNode.left);
            }
            i++;

            if (i<values.length && !values[i].equals("null")){
                currentNode.right=new TreeNode(Integer.parseInt(values[i]));
                queue.offer(currentNode.right);
            }
            i++;
        }
        int res = maxPathSum(root);
        System.out.println(res);
    }
    /**
     * 二叉树的最大路径和
     * @param root
     * @return
     */
    public  static int maxPathSum(TreeNode root) {
        getMax(root);
        return maxValue;
    }

    public static int getMax(TreeNode root){

        if (root == null){
            return 0;
        }

        int left = Math.max(getMax(root.left), 0);
        int right =Math.max(getMax(root.right),0);

        int currentValue =root.val + left + right;
        maxValue= Math.max(maxValue, currentValue);
        // 返回每个根节点的最大值
        return root.val + Math.max(left, right);
    }
}
