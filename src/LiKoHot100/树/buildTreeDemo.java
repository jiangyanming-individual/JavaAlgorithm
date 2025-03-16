package LiKoHot100.树;

public class buildTreeDemo {


    /**
     * 使用先序遍历和中序遍历来实现树的构建: 先找到middleIndex
     * @param inorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder,int[] inorder){
        if (preorder.length == 0 || inorder.length == 0){
            return null;
        }
        // 左闭右开
        return traversalTree(preorder,0,preorder.length,inorder,0,inorder.length);
    }
    public TreeNode traversalTree(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd){
        // 递归终止条件：
        if (preorderStart == preorderEnd){
            return null;
        }

        // 找到跟节点
        int rootValue= preorder[preorderStart];
        TreeNode root = new TreeNode(rootValue);

        // 特殊情况：
        if (preorderEnd -preorderStart == 1) return root;

        // 找到中序的中间节点index：
        int middleIndex;
        for ( middleIndex= inorderStart;middleIndex<inorderEnd;middleIndex++){
            if (inorder[middleIndex] == rootValue){
                break;
            }
        }
        // 分割中序：
        int LeftInorderStart= inorderStart;
        int LeftInorderEnd= middleIndex-1;
        int RightInorderStart= middleIndex+1;
        int RightInorderEnd =inorderEnd;

        // 分割前序：
        int LeftPreorderStart = preorderStart+1;
        int LeftPreorderEnd =preorderStart +1 + (middleIndex - inorderStart);
        int RightPreorderStart =LeftPreorderEnd;
        int RightPreorderEnd = preorderEnd;

        // 递归
        root.left=traversalTree(preorder, LeftPreorderStart, LeftPreorderEnd,inorder,LeftInorderStart,LeftInorderEnd);
        root.right=traversalTree(preorder,RightPreorderStart,RightPreorderEnd,inorder,RightInorderStart,RightInorderEnd);
        return root;

    }

}
