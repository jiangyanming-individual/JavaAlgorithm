package Tree.two;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 二叉搜索树中的众数
 */
public class findModeDemo {

    Map<Integer, Integer> map = new HashMap<>();

    public int[] findMode(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, map);
        //遍历map使用mapEntry <key,value>
        List<Map.Entry<Integer, Integer>> mapList = map.entrySet().stream().sorted((a1, a2) -> {
            //降序排列：
            return a2.getValue().compareTo(a1.getValue());
        }).collect(Collectors.toList());
        //取最大的值的频率：
        int max = mapList.get(0).getValue();
        //遍历mapList
        for (int i = 0; i < mapList.size(); i++) {
            if (mapList.get(i).getValue() == max) {
                result.add(mapList.get(i).getKey());
            } else {
                break;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    public void traversal(TreeNode root, Map map) {

        if (root == null) return;
        map.put(root.val, (int) map.getOrDefault(root.val, 0) + 1);
        traversal(root.left, map);
        traversal(root.right, map);
    }

}
