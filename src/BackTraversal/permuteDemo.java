package BackTraversal;

import java.util.ArrayList;
import java.util.List;

public class permuteDemo {
    /**
     * 排列问题 因为排列问题，每次都要从头开始搜索
     *
     *
     * 使用used 数组保证 path中的元素已经被使用
     */
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path= new ArrayList<>();
    boolean[] used;
    public List<List<Integer>>  permute(int[] nums){
        //used 数组是为了保证path中的元素不重复
        used=new boolean[nums.length];
        backtrabersal(nums);
        return result;

    }
    void backtrabersal(int[] nums){

        if (path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        //单层遍历：
        for (int i=0; i<nums.length; i++){

            if (used[i] == true){
                continue;
            }
            used[i] =true;
            path.add(nums[i]);
            backtrabersal(nums);
            used[i]=false;
            path.remove(path.size()-1);
        }

    }
}
