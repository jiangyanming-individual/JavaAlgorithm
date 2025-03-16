package BackTraversal.three;

import java.util.ArrayList;
import java.util.List;

public class permuteDemo {

    List<List<Integer>> result=new ArrayList<>();
    List<Integer> path=new ArrayList<>();
    public List<List<Integer>>  permute(int[] nums){
        if (nums.length == 0) return result;
        boolean[] used=new boolean[nums.length];
        traversal(nums,used);
        return result;
    }
    public void traversal(int[] nums,boolean[] used){

        //回溯终止条件
        if (path.size() == nums.length){
            //重新初始化：
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i=0;i<nums.length;i++){
            //当前元素被使用过就跳过
            if (used[i]){
                continue;
            }
            used[i]=true;
            path.add(nums[i]);
            traversal(nums,used);
            path.remove(path.size()-1);
            used[i]=false;
        }

    }
}
