package BackTraversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum2Demo {


    List<List<Integer>> result=new ArrayList<>();
    List<Integer> path= new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //先将元素进行排序：相同的元素相邻在一起
        Arrays.sort(candidates);
        backtraversal(candidates,target,0,0);
        return result;
    }

    public void backtraversal(int[] candidates,int target,int sum ,int startIndex){
        //回溯终止条件：
        if (sum > target){
            return;
        }
        if (sum == target){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++){
            //去重复；同一树层，水平方向不能重复
            if (i > startIndex && candidates[i] == candidates[i-1]){
                continue;
            }
            sum+=candidates[i];
            path.add(candidates[i]);
            backtraversal(candidates,target,sum,i+1); //因为只能使用一次；
            sum-=candidates[i];
            path.remove(path.size()-1);
        }
    }

}


