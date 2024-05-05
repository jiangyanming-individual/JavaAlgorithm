package Tree;

public class trimBSTDemo {


    public TreeNode trimBST(TreeNode root,int low, int high) {

        if (root == null) return root;
        //单层：如果当前节点不符合条件，而且小于left,但是其右孩子可能符合要求
        if (root.val < low){
            //往符合区间的右子树递归；
            TreeNode rightNode = trimBST(root.right, low, high);//右子树；返回符合区间的头节点；
            return rightNode;
        }
        //如果当前节点不符合条件，而且大于right,但是其左孩子可能符合要求
        if (root.val > high){
            //往左子树遍历；符合[low,high]的区间节点；返回符合节点的头节点
            TreeNode leftNode = trimBST(root.left, low, high);
            return leftNode;
        }

        //左遍历
        root.left=trimBST(root.left,low,high);
        //右遍历
        root.right=trimBST(root.right,low,high);
        return root;
    }
}
