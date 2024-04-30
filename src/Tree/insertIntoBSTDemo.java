package Tree;

public class insertIntoBSTDemo {


    public TreeNode insertIntoBST(TreeNode root,int val){

        //递归终止条件：
        if (root == null){
            return new TreeNode(val); //插入新节点；
        }
        //单层递归：
        if (root.val > val) {
            root.left = insertIntoBST(root.left,val);
        }

        if (root.val < val){
            root.right = insertIntoBST(root.right,val);
        }
        return root;
    }
}
