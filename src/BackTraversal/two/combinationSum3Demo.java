package BackTraversal.two;

import java.util.ArrayList;
import java.util.List;

public class combinationSum3Demo {

    public static void main(String[] args) {

    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {

        traversal(k,n,n,1);
        return result;
    }

    public void traversal(int k, int n, int sum, int startIndex) {
        //如果数组长度等于当前的k 而且sum =0
        if (path.size() == k){
            // 当结果等于0时取结果：
            if (sum == 0){
                result.add(new ArrayList<>(path));
            }
            return;
        }

        //回溯；
        for (int i=startIndex;i<= 9- (k -path.size()) +1; i++){
            path.add(i);
            sum -=i;
            traversal(k,n,sum,i+1);
            sum+=i;
            path.remove(path.size()-1);
        }
    }
}
