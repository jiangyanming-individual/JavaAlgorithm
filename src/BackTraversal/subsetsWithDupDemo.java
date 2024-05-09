package BackTraversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsetsWithDupDemo {


    List<List<Integer>> result=new ArrayList<List<Integer>>();
    List<Integer> path=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int [] nums){
        //去重需要排序：
        Arrays.sort(nums);
        backtraversal(nums,0);
        return result;
    }
    void backtraversal(int[] nums,int startIndex){

        result.add(new ArrayList<>(path));
        if (startIndex>=nums.length){
            return;
        }
        for (int i=startIndex;i<nums.length;i++){
            if (i>startIndex && nums[i] == nums[i-1]){ //同一层去重复
                continue;
            }
            path.add(nums[i]);
            backtraversal(nums,i+1);
            path.remove(path.size()-1);
        }

    }

}
