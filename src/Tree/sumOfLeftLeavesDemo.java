package Tree;

import java.util.Stack;

public class sumOfLeftLeavesDemo {

    /**
     * 递归处理
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root){
//        return traversal(root);
        Stack<TreeNode> stack = new Stack<>();
        if (root!=null) stack.push(root);

        int sum=0;
        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            if (node!=null){
                stack.pop();//避免多添加
                //中；
                stack.push(node);
                stack.push(null);
                if (node.left!=null && node.left.left==null && node.left.right==null){
                    sum+=node.left.val;
                }
                //右
                if (node.right!=null) stack.push(node.right);
                //左
                if (node.left!=null) stack.push(node.left);
            }else {
                stack.pop(); //删除null
                stack.pop(); //删除节点元素
            }
        }
        return sum;
    }

    public int traversal(TreeNode node){
        //递归终止
        if (node == null)return 0;
        if (node.left ==null && node.right == null) return 0;

        //单层递归调用：
        int leftSum = traversal(node.left);//左
        if (node.left!=null && node.left.left ==null && node.left.right ==null){
            leftSum=node.left.val;
        }

        int rightSum = traversal(node.right);//右
        return rightSum+ leftSum; //中
    }
}
