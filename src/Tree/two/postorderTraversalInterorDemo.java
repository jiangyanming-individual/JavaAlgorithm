package Tree.two;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class postorderTraversalInterorDemo {

    /**
     * 后序遍历
     * @return
     */
    List<Integer> postorderTraversal(TreeNode root){

        List<Integer> result=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        if (root == null){
            return result;
        }
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode peek = stack.peek();
            if (peek!=null){
                TreeNode pop = stack.pop();
                // 中；
                stack.push(pop);
                stack.push(null);
                // 右
                if (pop.right!=null){
                    stack.push(pop.right);
                }
                //左
                if (pop.left!=null){
                    stack.push(pop.left);
                }
            }else {
                stack.pop();
                //弹出实际的节点
                TreeNode node = stack.peek();
                stack.pop();
                result.add(node.val);
            }
        }
        return result;
    }
}
