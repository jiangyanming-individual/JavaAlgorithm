package Tree;

import java.util.*;

public class getMinmumDifferenceDemo {

    /**
     * 中序迭代遍历
     * @param root
     * @return
     */
    private TreeNode pre;
    private int result=Integer.MAX_VALUE;


    public int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>(); //栈来表示
        if (root!=null) stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            if (node!=null){
                stack.pop();
                if (node.right!=null){
                    stack.add(node.right);
                }
                stack.add(node);
                stack.add(null);
                if (node.left!=null){
                    stack.add(node.left);
                }
            }else {
                stack.pop();
                TreeNode temp = stack.pop();
                if (pre!=null){
                    result= Math.min(result,Math.abs(temp.val -pre.val));
                }
                pre=temp; //赋值给pre；
            }

        }

        return result;
    }

    /**
     * 递归
     * @param root
     * @return
     */

    public int getMinimumDifference2(TreeNode root) {

        if (root == null) return 0;
        traversal(root);
        return result;

    }

    public void traversal(TreeNode root) {
        if (root == null) return;

        traversal(root.left);
        if (pre!=null){
            result= Math.min(result,Math.abs(root.val - pre.val));
        }
        pre=root;
        traversal(root.right);
    }
}
