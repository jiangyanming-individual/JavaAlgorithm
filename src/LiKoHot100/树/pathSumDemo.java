package LiKoHot100.树;

import java.util.HashMap;
import java.util.Map;

public class pathSumDemo {


    /**
     * 路径总和： 这道题确实不会，实在不会啊。 使用前缀和的方式
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum){
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        return dfs(root, targetSum, 0, map);
    }

    public int dfs(TreeNode root, int targetSum, long currentSum, Map<Long,Integer> prefixMap){

        if (root ==null){
            return 0;
        }

        currentSum += root.val;
        int curCount =prefixMap.getOrDefault(currentSum - targetSum,0);
        // 更新hash
        prefixMap.put(currentSum, prefixMap.getOrDefault(currentSum,0) +1);
        // 递归遍历左右节点：
        int leftCount =dfs(root.left, targetSum, currentSum, prefixMap);
        int rightCount = dfs(root.right, targetSum, currentSum, prefixMap);
        // 回溯更新hashmap
        prefixMap.put(currentSum, prefixMap.get(currentSum)-1);
        return  curCount  +leftCount + rightCount;
    }
}
