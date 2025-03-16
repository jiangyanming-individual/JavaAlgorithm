package LiKoHot100.回溯;

import java.util.ArrayList;
import java.util.List;

public class combinationSumDemo {


    /**
     * 组合和
     * （1） 回溯终止条件： sum == target
     *  (2) 需要有一个起始的startIndex
     *  (3) 优化： if (sum > target) return;;
     * @param candidates
     * @param target
     * @return
     */

    List<List<Integer>> res =new ArrayList<>();
    List<Integer> path =new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if (candidates.length == 0){
            return res;
        }
        backTraversal(candidates,target,0,0);
        return res;
    }

    public void backTraversal(int[]candidates, int target, int sum, int startIndex){

        if (sum > target) return;;
        if (sum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=startIndex; i<candidates.length;i++){
            sum+= candidates[i];
            path.add(candidates[i]);
            // 回溯
            backTraversal(candidates,target,sum, i);
            path.remove(path.size()-1);
            sum-= candidates[i];
        }
    }
}
