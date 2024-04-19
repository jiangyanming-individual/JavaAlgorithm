package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class postorderTraversalDemo02 {

    /**
     * 后续遍历 左右中===》中右左
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root){

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root!=null) stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            if (node!=null){
                stack.pop();
                stack.push(node);
                stack.push(null); //中；
                if (node.right!=null) stack.push(node.right); //右
                if (node.left!=null) stack.push(node.left); //左
            }else {
                stack.pop(); //删除null
                TreeNode peek = stack.peek();
                list.add(peek.val);
                stack.pop(); //删除peek
            }
        }
        return list;
    }
}
