package BackTraversal.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 1. 递归终止条件：path.size() =nums.length;
 * 2. 去重的情况下，需要对nums执行排序操作
 * 3. 同一树层需要去重复, 在叶子节点收集结果
 * 4. used[i-1] ==false 表明同一树层使用过了
 * 5. 如果used[i] == false, 说明还没有使用，然后进行操作
 */
public class permuteUniqueDmeo {

    List<List<Integer>> result=new ArrayList<>();
    List<Integer> path=new ArrayList<>();
    //同一树层去重复
    public List<List<Integer>> permuteUnique(int[] nums){

        if (nums.length == 0) return result;
        Arrays.sort(nums);
        boolean[] used=new boolean[nums.length];
        return result;
    }
    public void backtracking(int[] nums, boolean[] used){

        if (path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i=0;i<nums.length;i++){
            //同一层去重
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false){
                continue;
            }
            //如果还没有使用
            if (used[i] ==false){
                used[i]=true;
                path.add(nums[i]);
                backtracking(nums,used);
                used[i]=false;
                path.remove(path.size()-1);
            }
        }
    }
}
