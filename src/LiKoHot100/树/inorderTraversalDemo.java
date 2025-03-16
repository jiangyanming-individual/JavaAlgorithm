package LiKoHot100.树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class inorderTraversalDemo {


    /**
     * 中序遍历： 递归 或者迭代的方法使用栈来解决
     * @param root
     * @return
     */

    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result =new ArrayList<>();
        // 使用栈和空指针标志位来实现
        Stack<TreeNode> stack = new Stack<>();
        if (root == null){
            return result;
        }
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode peek = stack.peek();
            // 处理节点
            if (peek!=null){
                // 先删除栈顶元素，避免重复操作
                stack.pop();
                // 右
                if (peek.right!=null){
                    stack.add(peek.right);
                }
                // 中
                stack.add(peek);
                stack.add(null);
                // 左
                if (peek.left!=null){
                    stack.add(peek.left);
                }
            }else {
                // 删除null 节点
                TreeNode top = stack.pop();
                // 真实的节点,要执行出栈的操作
                TreeNode node = stack.pop();
                result.add(node.val);
            }
        }
        // 返回结果集
        return result;
    }

    public List<Integer> inorderTraversal2(TreeNode root){
        List<Integer> result =new ArrayList<>();
        inorder(root, result);
        return result;
    }

    // 递归+ 递归终止条件：
    public void inorder(TreeNode root, List result){
        if ( root == null){
            return;
        }
        inorder(root.left,result);
        result.add(root.val);
        inorder(root.right,result);
    }

}
