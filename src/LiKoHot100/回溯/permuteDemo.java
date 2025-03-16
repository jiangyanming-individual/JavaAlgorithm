package LiKoHot100.回溯;

import java.util.ArrayList;
import java.util.List;

public class permuteDemo {


    /**
     * 全排列：是需要用上所有的数字，而且要求是有顺序的。
     * @param nums
     * @return
     */
    List<List<Integer>> res =new ArrayList<>();
    List<Integer> path =new ArrayList<>();
    public List<List<Integer>> permute(int[] nums){

        if (nums.length == 0){
            return res;
        }
        boolean[] used = new boolean[nums.length];
        traversal(nums,used);
        return res;
    }

    /**
     * 进行回溯操作
     */
    public void  traversal(int[] nums, boolean[] used){

        //回溯终止条件：
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i=0;i<nums.length;i++){
            // 如果used== true 说明被使用过了直接跳过：
            if (used[i]){
                continue;
            }
            used[i] =true;
            path.add(nums[i]);
            // 回溯过程：
            traversal(nums, used);
            path.remove(path.size()-1);
            used[i]=false;
        }
    }

}
