package LiKoHot100.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrderDemo {

    /**
     *二叉树的层次遍历： 使用队列先实现
     * (1) 先加根节点。然后计算每一层节点有多少个，
     * (2) 用一个临时列表存储一层的结果
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root){

        List<List<Integer>> result = new ArrayList<>();
        // 使用队列
        Queue<TreeNode> queue=new LinkedList<>();
        if (root == null){
            return result;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            // 计算队列的大小
            int size = queue.size();
            // 存储一层的临时列表
            List<Integer> tempList = new ArrayList<>();
            while (size>0){
                TreeNode poll = queue.poll();
                tempList.add(poll.val);
                if (poll.left!=null){
                    queue.add(poll.left);
                }
                if (poll.right!=null){
                    queue.add(poll.right);
                }
                size--;
            }
            // 每一层计算完，将一层的结果集加入到结果集中
            result.add(tempList);
        }
        //返回结果集
        return result;
    }
}
