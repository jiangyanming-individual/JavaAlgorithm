package LiKoHot100.树;

import java.util.HashMap;
import java.util.Map;

public class pathSumDemo2 {


    /**
     * 路径总和： 使用前缀和进行解题；
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root ,int targetSum){

        Map<Long, Integer> hashMap = new HashMap<>();
        hashMap.put(0L,1);
        // 递归调用
        return dfs(root,targetSum, hashMap,0);

    }
    public int dfs(TreeNode root, int targetSum, Map<Long, Integer> preHashMap, long currentSum){
        if (root == null){
            return 0;
        }
        currentSum += root.val;

        // 获取当前节点前缀和有多少个
        int curCount = preHashMap.getOrDefault(currentSum -targetSum, 0);
        // 更新hashmap
        preHashMap.put(currentSum, preHashMap.getOrDefault(currentSum, 0) +1);
        int leftCount =  dfs(root.left,targetSum, preHashMap,currentSum);
        int rightCount =dfs(root.right, targetSum, preHashMap, currentSum);
        // 回溯：
        preHashMap.put(currentSum,preHashMap.get(currentSum) -1);

        // 返回所有的和
        return curCount + leftCount + rightCount;
    }

}
