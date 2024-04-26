package Tree;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 */
public class buildTreeDemo02 {

    public TreeNode buildTree(int[] preorder,int [] inorder){
        if (inorder.length ==0 || preorder.length == 0){
            return null;
        }

        return traversal(preorder,0,preorder.length,inorder,0,inorder.length);

    }
    public TreeNode traversal(int [] preorder, int preorderStart, int preorderEnd, int [] inorder, int inorderStart,int inorderEnd){

        if (preorderStart == preorderEnd) return null;
        int rootVal=preorder[preorderStart];
        TreeNode root = new TreeNode(rootVal);

        int middleIndex;
        for ( middleIndex = inorderStart; middleIndex <inorderEnd ; middleIndex++) {
            if (inorder[middleIndex] == rootVal) break;
        }

        int leftInorderStart=inorderStart;
        int leftInorderEnd=middleIndex;
        int rightInorderStart=middleIndex+1;
        int rightInorderEnd=inorderEnd;

        //左闭右开的区间
        int leftPreorderStart=preorderStart+1;
        int leftPreorderEnd=preorderStart +(middleIndex- inorderStart)  +1;
        int rightPreorderStart=leftPreorderEnd;
        int rightPreorderEnd=preorderEnd;

        root.left=traversal(preorder,leftPreorderStart,leftPreorderEnd,inorder,leftInorderStart,leftInorderEnd);
        root.right=traversal(preorder,rightPreorderStart,rightPreorderEnd,inorder,rightInorderStart,rightInorderEnd);
        return root;
    }

}
