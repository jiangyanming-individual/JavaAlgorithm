package BackTraversal;

import java.util.ArrayList;
import java.util.List;

public class combineDemo {


    private List<List<Integer>> result =new ArrayList<>();
    private List<Integer> path= new ArrayList<>();

    public List<List<Integer>> combine(int n, int k){

        backtraversal(n,k,1);
        return result; //返回结果集；
    }

    public void backtraversal(int n, int k, int startIndex){

        //回溯终止条件：
        if (path.size() == k){
            result.add(new ArrayList<Integer>(path)); //new 一个新的List
            return;
        }

        //回溯过程
        for (int i=startIndex;i<=n;i++){
            path.add(i);
            backtraversal(n,k,i+1); //递归
            path.remove(path.size()-1); //回溯,移除最后一个元素；
        }
    }

    //优化
    public void backtraversal2(int n, int k, int startIndex){

        //回溯终止条件：
        if (path.size() == k){
            result.add(new ArrayList<Integer>(path)); //new 一个新的List
            return;
        }

        //回溯过程
        for (int i=startIndex;i<=n - (k -path.size()) + 1;i++){ // n- i >= (k -path.size)
            path.add(i);
            backtraversal(n,k,i+1); //递归
            path.remove(path.size()-1); //回溯,移除最后一个元素；
        }
    }
}
