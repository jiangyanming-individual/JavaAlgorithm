package Tree.two;

public class insertIntoBSTDemo {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        //递归
        if (root.val<val){
            //右子树
            root.right=insertIntoBST(root.right,val);
        }
        if (root.val>val){
            //左子树
            root.left=insertIntoBST(root.left,val);
        }
        return root;
    }

}
