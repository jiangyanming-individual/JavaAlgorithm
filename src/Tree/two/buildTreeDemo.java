package Tree.two;

public class buildTreeDemo {


    /**
     * 使用中序和后续遍历，构造树：
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        //左闭，右开
        return traversalTree(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }
    public TreeNode traversalTree(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int postorderEnd) {

        //递归终止：数组为空
        if (postorderStart == postorderEnd) {
            return null;
        }

        //找到后续遍历的最后一个节点；
        int nodeValue = postorder[postorderEnd - 1];
        TreeNode root = new TreeNode(nodeValue);
        //分割中序
        int middleIndex;
        for (middleIndex = inorderStart; middleIndex < inorderEnd; middleIndex++) {
            if (inorder[middleIndex] == nodeValue) {
                break;
            }
        }

        int leftInorderStart = inorderStart;
        int leftInorderEnd = middleIndex;
        int rightInorderStart = middleIndex + 1;//中间节点已经取了
        int rightInorderEnd = inorderEnd;

        //分割后续

        int leftPostorderStart = postorderStart;
        int leftPostorderEnd = postorderStart + (middleIndex - inorderStart);
        int rightPostorderStart = leftPostorderStart;
        int rightPostorderEnd = postorderEnd-1; //减去最后一个节点，因为用过了

        // 递归

        root.left=traversalTree(inorder,leftInorderStart,leftInorderEnd,postorder,leftPostorderStart,leftPostorderEnd);
        root.right=traversalTree(inorder,rightInorderStart,rightInorderEnd,postorder,rightPostorderStart,rightPostorderEnd);
        return root;
    }


}



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder,int[] postorder){

        if (inorder.length == 0 || postorder.length == 0) return null;
        return traversal(inorder,0,inorder.length,postorder,0,postorder.length); //左闭右开；
    }

    public TreeNode traversal(int[] inorder,int inorderStart,int inorderEnd,int[] postorder,int postorderStart, int postorderEnd){

//        第一步：如果数组大小为零的话，说明是空节点了。。
        if(postorderStart == postorderEnd)
            return null;
//        第二步：如果不为空，那么取后序数组最后一个元素作为节点元素。
        int nodeValue= postorder[postorderEnd-1];
        TreeNode root = new TreeNode(nodeValue);

//      第三步：找到后序数组最后一个元素在中序数组的位置，作为切割点
        int middleIndex; //[left,right)
        for (middleIndex = inorderStart; middleIndex < inorderEnd; middleIndex++) {
            if (inorder[middleIndex] == nodeValue) break; //找到中序的中间节点；
        }
//        第四步：切割中序数组，切成中序左数组和中序右数组 （顺序别搞反了，一定是先切中序数组）
        int leftinorderStart= inorderStart;
        int leftinorderEnd= middleIndex;
        int rightinorderStart= middleIndex+1; //把中间节点跳过；
        int rightinorderEnd =inorderEnd;
//        第五步：切割后序数组，切成后序左数组和后序右数组
        int leftpostorderStart= postorderStart;
        int leftpostorderEnd= postorderStart + (middleIndex - inorderStart); // start + size;
        int rightpostorderStart= leftpostorderEnd; //左闭右开；
        int rightpostorderEnd=postorderEnd-1; //减去最后一个；

//        第六步：递归处理左区间和右区间
        root.left=traversal(inorder,leftinorderStart,leftinorderEnd,postorder,leftpostorderStart,leftpostorderEnd);
        root.right=traversal(inorder,rightinorderStart, rightinorderEnd,postorder,rightpostorderStart,rightpostorderEnd);
        return root;
    }
}