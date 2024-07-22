package BackTraversal.two;

import java.util.ArrayList;
import java.util.List;

public class combineDemo {

    /**
     * void backtracking(参数) {
     * if (终止条件) {
     * 存放结果;
     * return;
     * }
     * <p>
     * for (选择：本层集合中元素（树中节点孩子的数量就是集合的大小）) {
     * 处理节点;
     * backtracking(路径，选择列表); // 递归
     * 回溯，撤销处理结果
     * }
     * }
     *
     * @param n
     * @param k
     * @return
     */

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        traversal(n, k, 1);
        return result;
    }


    public void traversal(int n, int k, int startIndex) {


        //加入结果集：
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        //递归和回溯；
//        for (int i = startIndex; i <= n; i++) {
//
//            path.add(i); //递归
//            traversal(n, k, i + 1);
//            path.remove(path.size() - 1);//回溯
//        }

        //剪枝的操作：
        for (int i = startIndex; i <= n -(k-path.size()) +1; i++) {

            path.add(i); //递归
            traversal(n, k, i + 1);
            path.remove(path.size() - 1);//回溯
        }
    }


}
