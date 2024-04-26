package Tree;
import java.util.Stack;

public class isValidBSTDemo {

    Long maxValue=Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root){
        if (root ==null) return true;
        return traversal(root);
    }

    //中序遍历保证，结果是递增的；
    public boolean traversal(TreeNode root){
        //递归终止：
        if (root == null) return true;
        //单层递归：
        boolean left=traversal(root.left);
        if (maxValue< root.val){
            //保证，中序遍历的结果是单调递增的
            maxValue= (long) root.val;
        }else {
            return false;
        }

        boolean right = traversal(root.right);
        return left && right;
    }


    /**
     * 迭代的方法
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre=null;
        if (root== null)return true;
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            if (node!=null){
                stack.pop();
                //右；
                if (node.right!=null) stack.push(node.right);
                //中；
                stack.push(node);
                stack.push(null);
                //左
                if (node.left!=null) stack.push(node.left);
            }else {
                stack.pop();//删除null
                TreeNode tempNode = stack.pop();
                //大于或者等于当前节点的，都不符合要求
                if (pre!=null && pre.val >=tempNode.val) return false;
                pre=tempNode; //赋值给pre 前一个节点；
            }
        }
        return true;
    }
}
