package Tree;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class inorderTraversalDemo02 {


    /**
     * 中序遍历  左中右===》右中左
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root){

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root!=null) stack.push(root);

        while (!stack.isEmpty()){

            TreeNode node = stack.peek();
            if (node!=null){
                stack.pop();
                if (node.right!=null) stack.push(node.right);
                stack.push(node);
                stack.push(null);
                if (node.left!=null) stack.push(node.left);
            }else{
                stack.pop();//删除null;
                TreeNode peek = stack.peek();
                list.add(peek.val);
                stack.pop();//删除结果元素；
            }
        }
        return list;
    }
}
