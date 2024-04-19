package Tree;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class preorderTraversalDemo02 {

    /**
     * 前序遍历 中左右==》右左中
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root!=null) stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            if (node!=null){
                stack.pop();//弹出栈头，避免重复处理
                if (node.right!=null){ //右
                    stack.push(node.right);
                }
                if (node.left!=null){ //左
                    stack.push(node.left);
                }
                stack.push(node); //中
                stack.push(null);//添加一个空
            }else {
                stack.pop();//删除null;
                TreeNode peek = stack.peek(); //加u人结果集
                stack.pop();//删除要加入结果的元素
                list.add(peek.val);
            }
        }
        return list;
    }
}
