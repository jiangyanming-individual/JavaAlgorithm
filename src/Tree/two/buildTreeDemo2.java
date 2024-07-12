package Tree.two;

public class buildTreeDemo2 {


    /**
     * 前序和中序实现构造树
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        return traversal(preorder, 0, preorder.length, inorder, 0, inorder.length);

    }

    public TreeNode traversal(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd) {

        if (preorderStart == preorderEnd) {
            return null;
        }

        int rootValue = preorder[preorderStart];
        TreeNode root = new TreeNode(rootValue);

        //仅有一个root；
        if (preorderEnd - preorderStart == 1) return root;

        //找到中序节点的index；

        int middleIndex;
        for (middleIndex = inorderStart; middleIndex < inorderEnd; middleIndex++) {
            if (inorder[middleIndex] == rootValue) break;
        }

        //分割中序：

        int leftInorderStart = inorderStart;
        int leftInorderEnd = middleIndex;
        int rightInorderStart = middleIndex + 1;
        int rightInorderEnd = inorderEnd;

        //分割前序；
        int leftPreorderStart = preorderStart + 1;
        int leftPreorderEnd = preorderStart + 1 + (middleIndex - inorderStart);
        int rightPreorderStart = leftPreorderEnd;
        int rightPreorderEnd = preorderEnd;


        root.left = traversal(preorder, leftPreorderStart, leftPreorderEnd, inorder, leftInorderStart, leftInorderEnd);
        root.right = traversal(preorder, rightPreorderStart, rightPreorderEnd, inorder, rightInorderStart, rightInorderEnd);

        return root;
    }


}
