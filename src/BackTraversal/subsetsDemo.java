package BackTraversal;

import java.util.ArrayList;
import java.util.List;

public class subsetsDemo {

    List<List<Integer>> result=new ArrayList<List<Integer>>();
    List<Integer> subset=new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtraversal(nums,0);
        return result;
    }

    void backtraversal(int[] nums,int startIndex){

        result.add(new ArrayList<>(subset)); //每个元素都要加入：
        //回溯终止条件：
        if (startIndex >=nums.length){
            return;
        }
        for (int i=startIndex; i<nums.length;i++){

            subset.add(nums[i]);
            backtraversal(nums,i+1);
            subset.remove(subset.size()-1);
        }
    }
}
