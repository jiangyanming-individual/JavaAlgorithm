package LiKoHot100.树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class preorderTraversalDemo {



    public List<Integer> preorderTraversal(TreeNode treeNode){

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (treeNode == null){
            return result;
        }
        stack.add(treeNode);
        while (!stack.isEmpty()){
            TreeNode peek = stack.peek();
            if (peek!=null){
                stack.pop();
                // 右
                if (peek.right!=null){
                    stack.add(peek.right);
                }
                // 左
                if (peek.left!=null){
                    stack.add(peek.left);
                }
                // 中
                stack.add(peek);
                stack.add(null);
            }else {
                // 删除空指针
                TreeNode top = stack.pop();
                // 加入到结果集
                TreeNode curNode = stack.pop();
                result.add(curNode.val);

            }
        }
        return result;

    }

    /**
     * 递归实现前序遍历
     * @param treeNode
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode treeNode){
        ArrayList<Integer> result = new ArrayList<>();
        traversal(treeNode,result);
        return result;
    }

    public void traversal(TreeNode root, List<Integer> result){

        if (root == null){
            return;
        }
        result.add(root.val);
        traversal(root.left,result);
        traversal(root.right,result);
    }
}
