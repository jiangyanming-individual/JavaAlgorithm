package BackTraversal.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class permuteUniqueDemo {


    /**
     * 回溯终止条件： path.size == nums.length
     * 同一树层需要去重复的操作，i>0 && nums[i] == nums[i-1] && used[i-1] =false
     */
    List<List<Integer>> result=new ArrayList<>();
    List<Integer> path=new ArrayList<>();
    //同一树层去重复, 需要进行排序操作
    public List<List<Integer>> permuteUnique(int[] nums){
        if (nums.length == 0) return result;
        Arrays.sort(nums);
        boolean[] used=new boolean[nums.length];
        Arrays.fill(used,false);
        traversal(nums,used);
        return result;
    }


    public void traversal(int[] nums,boolean[] used){

        // 回溯终止条件：
        if (path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        //0-n
        for (int i=0;i<nums.length;i++){
            // 去重复：used[i-1] =false 说明同一树层使用过了
            if (i > 0 && nums[i - 1] == nums[i] && used[i - 1] == false){
                continue;
            }
            // 如果当前节点还没有被使用
            if (used[i] ==false){
                used[i]=true;
                path.add(nums[i]);
                traversal(nums,used);
                path.remove(path.size()-1);
                used[i]=false;
            }
        }

    }
}
