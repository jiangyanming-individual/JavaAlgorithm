package BackTraversal.two;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合：
 */
public class combinationSumDemo {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    //可以重复使用
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        traversal(candidates, target, 0, 0);
        return result;
    }

    /**
     * 回溯：
     * @param candidates
     * @param target
     * @param sum
     * @param startIndex
     */
    public void traversal(int[] candidates, int target, int sum, int startIndex) {
        //剪枝：
        if (sum > target) {
            return;
        }

        //收集结果：
        if (target == sum) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            sum += candidates[i];
            path.add(candidates[i]);
            //startIndex 从0开始：
            traversal(candidates, target, sum, i);
            path.remove(path.size() - 1);
            sum -= candidates[i];
        }
    }
}
