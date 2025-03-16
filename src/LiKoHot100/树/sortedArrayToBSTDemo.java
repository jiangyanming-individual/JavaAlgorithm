package LiKoHot100.树;

public class sortedArrayToBSTDemo {


    /**
     * 将有序数组转为二叉搜索树， 这个需要将数组转为二叉搜索树
     * 使用递归实现， 首先需要获取到中间节点 nums[mid]， 然后递归调用，给左右节点进行赋值操作。
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums){

        return traversal(nums,0,nums.length-1);
    }

    public TreeNode traversal(int[] nums, int start,int end){

        // 递归终止条件
        if (start>end){
            return null;
        }

        // 根节点；
        int mid =(start + end) /2 ;
        TreeNode treeNode = new TreeNode(nums[mid]);
        // 设置左右节点
        treeNode.left =traversal(nums,start, mid-1);
        treeNode.right =traversal(nums,mid+1 ,end);
        return treeNode;

    }
}
