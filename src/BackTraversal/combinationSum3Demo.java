package BackTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class combinationSum3Demo {

    /**
     * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
     *
     * 只使用数字1到9
     * 每个数字 最多使用一次
     */
    List<List<Integer>> result= new ArrayList<>();
    List<Integer> path=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtraversal(n,k, 0, 1);
        return result;
    }


    public void  backtraversal(int targetSum,int k ,int sum,int startIndex) {
        //回溯终止条件；
        if (path.size() == k){
            //如果目标值等于sum
            if (targetSum == sum){
                result.add(new ArrayList<>(path));
            }
            return;
        }

        //数字1-9
        for (int i=startIndex;i<=9 - (k - path.size()) +1; i++){ //剪支操作
            sum+=i;
            path.add(i);
            backtraversal(targetSum,k, sum, i+ 1); //递归
            sum-=i;
            path.remove(path.size()-1);//回溯移除最后一个元素；
        }
    }
}
