package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class findBottomLeftValueDemo {

//    public int findBottomLeftValue(TreeNode root){
//
//        //层次遍历：
//        Queue<TreeNode> queue=new LinkedList<>();
//        int result=0; //返回值
//        if (root!=null) queue.add(root);
//        while (!queue.isEmpty()){
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode node = queue.poll();
//                if (i==0){
//                    result=node.val; //记录每一层的第一个元素,最后直接返回元素
//                }
//                if (node.left!=null)queue.add(node.left);
//                if (node.right!=null) queue.add(node.right);
//            }
//        }
//        return result;
//    }

    /**递归实现
     *
     * @param root
     * @return
     */
    private int maxDepth=-1;
    private int value=0;
    public int findBottomLeftValue(TreeNode root){

        traversal(root,0);
        return value;
    }
    public void traversal(TreeNode node,int depth){
        //递归终止条件：到达叶子节点，重新计算高度
        if (node.left == null && node.right ==null){
            if (depth>maxDepth){
                //更新最大高度和左节点的值；
                maxDepth=depth;
                value=node.val;
            }
        }
        //单层递归：
        if (node.left!=null){
            depth++;
            traversal(node.left,depth);
            depth--; //回溯
        }
        if (node.right!=null){
            depth++;
            traversal(node.right,depth);
            depth--;
        }
    }
}
