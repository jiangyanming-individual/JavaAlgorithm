package Tree;

/**
 * 将有序数组转换为二叉搜索树
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵
 * 平衡
 *  二叉搜索树。
 */
public class sortedArrayToBSTDemo {
    public TreeNode sortedArrayToBST(int[] nums) {

        TreeNode node = traversal(nums, 0, nums.length - 1);
        return node;
    }

    //递归， 数组区间[left, right]
    public TreeNode traversal(int[] nums,int left, int right){
        //递归终止条件：
        if (left > right){
            return null;
        }

        //单层递归
        int mid =left  +(right - left) /2;
        //加入新节点为根节点；
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left =traversal(nums,left, mid-1);
        treeNode.right= traversal(nums,mid+1, right);

        return treeNode;
    }
}
