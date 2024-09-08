package BackTraversal.two;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class combineDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt();
        int k= scanner.nextInt();


    }

    List<Integer> path=new ArrayList<>();
    List<List<Integer>> res=new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

       backtracking(n,k,1);
       return res;
    }

    public void backtracking(int n,int k,int startIndex){
        //回溯终止条件：
        if (path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        // 递归和回溯：
        for (int i=startIndex;i<=n - (k- path.size()) +1;i++){
            path.add(i);
            // 回溯
            backtracking(n,k,i+1); //下一层开始的startIndex;
            //移除最后一个元素
            path.remove(path.size()-1);
        }
    }

}
