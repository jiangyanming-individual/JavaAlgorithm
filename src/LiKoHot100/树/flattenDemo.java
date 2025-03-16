package LiKoHot100.树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class flattenDemo {


    /**
     * 二叉树展开为链表： 前序遍历 + 递归的方法实现。
     * @param root
     */

    List<TreeNode> list =new ArrayList<>();
    public void  flatten(TreeNode root){
        traversal(root);
        int size = list.size();

        for (int i=1;i<size;i++){
            TreeNode preNode =list.get(i-1);
            TreeNode curNode =list.get(i);
            preNode.left=null;
            preNode.right=curNode;
        }
    }

    public void  traversal(TreeNode root){

        if (root == null){
            return;
        }
        list.add(root);
        if (root.left!=null){
            traversal(root.left);
        }
        if (root.right!=null){
            traversal(root.right);
        }
    }


    /**
     * 使用迭代的方法： 中左右===》 右左中
     * @param root
     */
    public void flatten2(TreeNode root){
        if (root == null){
            return;
        }

        Deque<TreeNode> stack=new LinkedList<>();
        stack.add(root);
        // 前指针节点
        TreeNode preNode =null;
        while (!stack.isEmpty()){
            // 当前栈的节点：curNode:
            TreeNode curNode = stack.poll();

            //新设置链表：
            if (preNode!=null){
                preNode.left=null;
                preNode.right=curNode;
            }
            // 右：
            if (curNode.right!=null){
                stack.push(curNode.right);
            }
            // 左：
            if (curNode.left!=null){
                stack.push(curNode.left);
            }
            // 中；
            preNode = curNode;

        }
    }
}
