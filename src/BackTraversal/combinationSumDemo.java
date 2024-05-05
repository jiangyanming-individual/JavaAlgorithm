package BackTraversal;

import java.util.ArrayList;
import java.util.List;

public class combinationSumDemo {


    List<List<Integer>> result=new ArrayList<>();
    List<Integer> path=new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates,int target){
        backtraversal(candidates,target,0,0);
        return result;
    }

    public void  backtraversal(int [] candidates,int target,int sum,int startIndex){

        //如果加的结果大于target也需要return
        if (sum > target){
            return;
        }

        if (target == sum){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i=startIndex;i<candidates.length;i++){
            sum+=candidates[i];
            path.add(candidates[i]);
            backtraversal(candidates,target,sum,i); //不需要加1
            sum-=candidates[i];
            path.remove(path.size()-1);

        }
    }
}
