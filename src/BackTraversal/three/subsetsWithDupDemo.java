package BackTraversal.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsetsWithDupDemo {


    /**
     * 1. 取结果，支取叶子节点。
     * 2. 终止条件，startIndex>=nums.length;
     * 3. startIndex =i+1,下一层操作
     * 3. 同一树层去重操作，i>startIndex && nums[i-1] == nums[i]
     */
    List<List<Integer>> result=new ArrayList<List<Integer>>();
    List<Integer> path=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int [] nums){
        //去重需要排序：
        Arrays.sort(nums);
        backtraversal(nums,0);
        return result;
    }

    public void backtraversal(int[] nums,int startIndex){

        result.add(new ArrayList<>(path));
        if (startIndex>=nums.length){
            return;
        }
        for (int i=startIndex;i<nums.length;i++) {
            // 同一层用过了
            if (i>startIndex && nums[i] == nums[i-1]){
                continue;
            }
            path.add(nums[i]);
            backtraversal(nums,i+1);//下一层
            path.remove(path.size()-1);
        }
    }
}
