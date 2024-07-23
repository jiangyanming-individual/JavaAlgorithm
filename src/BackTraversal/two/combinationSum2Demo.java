package BackTraversal.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum2Demo {


    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        used = new boolean[candidates.length];
        Arrays.fill(used, false);
        Arrays.sort(candidates);
        traversal(candidates, target, 0, 0);
        return result;
    }

    public void traversal(int[] candidates, int target, int sum, int startIndex) {
        if (sum > target) {
            return;
        }
        //收集结果
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            //树层去重：
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            sum += candidates[i];
            path.add(candidates[i]);
            //去重复
            traversal(candidates, target, sum, i + 1);
            path.remove(path.size() - 1);
            sum -= candidates[i];
            used[i] = false;
        }
    }

}
