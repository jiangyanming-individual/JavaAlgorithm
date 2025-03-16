package LiKoHot100.回溯;

import java.util.ArrayList;
import java.util.List;

public class subsetsDemo {


    /**
     * 子集问题：就是遍历树的每一个节点，包括根节点到叶子节点 以及单独的节点node
     * (1) 回溯终止条件： startIndex >= nums.length ();
     * (2) i的起始位置是startIndex
     * (3) 回溯过程中 startIndex = i +1;
     *
     */
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path =new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {

        if (nums.length == 0 ){
            return  res;
        }
        backTraversal(nums,0);
        return res;
    }
    public void backTraversal(int[] nums, int startIndex){

        // 刚开始就需要加入到结果集，避免漏掉：
        res.add(new ArrayList<>(path));

        // 回溯终止条件，到达叶子节点了已经
        if (startIndex>= nums.length){
            return;
        }

        // i的起始位置是startIndex
        for (int i=startIndex;i<nums.length;i++){
            path.add(nums[i]);
            // 回溯， 并且起始startIndex =i+1
            backTraversal(nums,i+1);
            path.remove(path.size()-1);
        }

    }
}
