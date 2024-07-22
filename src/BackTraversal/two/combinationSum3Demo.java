package BackTraversal.two;

import java.util.ArrayList;
import java.util.List;

public class combinationSum3Demo {


    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {

        traversal(k, n, 0, 1);
        return result;
    }


    public void traversal(int k, int n, int sum, int startIndex) {
        if (sum >n){
            return;
        }
        if (path.size() == k) {
            if (sum == n) {
                result.add(new ArrayList<>(path));
            }
        }
        //剪枝操作
        for (int i = startIndex; i <= 9 -(k-path.size()) +1; i++) {
            sum += i;
            path.add(i);
            traversal(k, n, sum, i + 1);
            path.remove(path.size() - 1);
            sum -= i;
        }
    }
}
