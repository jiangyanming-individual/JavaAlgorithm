package Tree;

/**
 * 654. 最大二叉树
 * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:

 * 创建一个根节点，其值为 nums 中的最大值。
 * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
 * 返回 nums 构建的 最大二叉树 。
 */
public class constructMaximumBinaryTreeDemo {

    public TreeNode constructMaximumBinaryTree(int[] nums){
        if (nums.length == 0) return null;
        return traversal(nums,0,nums.length); //左边闭右开
    }

    public TreeNode traversal(int[] nums, int start,int end){
        //递归终止条件，start>=end;
        if (start>=end) return null; //递归到叶子节点，直接返回null；

        int maxIndex=start;
        for (int i=start+1;i<end;i++){
            if (nums[i]> nums[maxIndex]){
                maxIndex=i;
            }
        }

        //构造根节点：
        TreeNode root = new TreeNode(nums[maxIndex]);
        int leftStart=start;
        int leftEnd=maxIndex;
        int rightStart=maxIndex+1;
        int rightEnd=end;

        root.left=traversal(nums,leftStart,leftEnd);
        root.right=traversal(nums,rightStart,rightEnd);
        return root;
    }
}
