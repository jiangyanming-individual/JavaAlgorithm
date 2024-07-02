package Tree.two;

import java.util.*;

public class inorderTraversalInterorDemo {


    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result=new ArrayList<>();
        //新定义一个栈：
        Stack<TreeNode> stack=new Stack<>();
        if (root == null){
            return result;
        }
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode peek = stack.peek();
            if (peek!=null){
                //弹出根节点：
                TreeNode pop = stack.pop();
                //右：
                if (pop.right!=null) stack.push(pop.right);
                //中，处理中间节点：
                stack.add(pop);
                stack.add(null);
                //左
                if (pop.left!=null) stack.push(pop.left);
            }else {
                //弹出节点是null， 需要处理下一个节点；
                stack.pop();
                //弹出处理后的节点：
                TreeNode node = stack.peek();
                stack.pop();
                result.add(node.val);//加入结果集
            }
        }
        return result;
    }
}
