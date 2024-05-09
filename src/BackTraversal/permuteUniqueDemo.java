package BackTraversal;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permuteUniqueDemo {

    /**
     * 需要在同一层上去重复的元素：
     */
    List<List<Integer>> result=new ArrayList();
    List<Integer> path=new ArrayList<>();

    boolean[] used;
    //同一树层去重复
    public List<List<Integer>> permuteUnique(int[] nums){
        Arrays.sort(nums); //排序：
        used=new boolean[nums.length];
        Arrays.fill(used, false);
        backtraversal(nums,used);
        return result;
    }
    void backtraversal(int [] nums,boolean [] used){

        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i=0;i<nums.length;i++){

            // used[i - 1] == true，说明同一树枝nums[i - 1]使用过
            // used[i - 1] == false，说明同一树层nums[i - 1]使用过
            if (i >0 && nums[i] == nums[i-1] && used[i - 1] ==false ) {
                continue;
            }
            //如果同一个树枝上的元素还没有使用：
            if (used[i] == false){

                used[i] =true;
                path.add(nums[i]);
                backtraversal(nums,used); //递归；
                path.remove(path.size()-1);//回溯
                used[i]=false; //回溯
            }
        }

    }
}
