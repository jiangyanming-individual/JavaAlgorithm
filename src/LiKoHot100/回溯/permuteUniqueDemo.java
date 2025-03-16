package LiKoHot100.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permuteUniqueDemo {


    /**
     * 排列2 ， 数组里面允许有重复的元素，此时需要考虑对同一树层进行去重复的操作：
     * （1） 需要对数组进行升序操作
     * (2) 需要同一树进行去重操作： i >0 && nums[i] == nums[i-1] && used[i-1] =false。
     * （3）需要设置一个boolean类型的数组
     * （4） 回溯终止条件： nums.length == path.size
     * @param nums
     * @return
     */

    List<List<Integer>> res =new ArrayList<>();
    List<Integer> path =new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums){
        if (nums.length == 0){
            return res;
        }
        boolean[] used = new boolean[nums.length];
        // 需要对数组进行排序：
        Arrays.sort(nums);
        traversal(nums,used);
        return  res;
    }
    public void  traversal(int[] nums, boolean[] used){

        if (nums.length == path.size()){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i=0;i<nums.length;i++){
            // 同一树层去重复
            if (i>0 && nums[i] == nums[i-1] && used[i-1] == false){
                continue;
            }
            // 如果当前节点还没有被使用
            if (used[i] == false){
                used[i] =true;
                path.add(nums[i]);
                traversal(nums,used);
                path.remove(path.size()-1);
                used[i] =false;
            }
        }
    }
}
