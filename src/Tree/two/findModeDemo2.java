package Tree.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class findModeDemo2 {

    Map<Integer, Integer> map = new HashMap<>();
    public int[] findMode(TreeNode root) {
        if (root == null) return null;
        //结果集
        List<Integer> result = new ArrayList<>();
        traversal(root);
        //排序：
        List<Map.Entry<Integer, Integer>> collect = map.entrySet().stream().sorted((a1, a2) -> {
            return a2.getValue().compareTo(a1.getValue());
        }).collect(Collectors.toList());

        //最大众数的值：
        int number = collect.get(0).getValue();
        for (int i = 0; i < collect.size(); i++) {
            if (collect.get(i).getValue() == number) {
                result.add(collect.get(i).getKey());
            } else {
                break;
            }
        }
        //转为array;
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 遍历
     *
     * @param root
     */
    public void traversal(TreeNode root) {

        if (root == null) return;
        traversal(root.left);
        //累加和：
        map.put(root.val, map.getOrDefault(root.val, 0) +1);
        traversal(root.right);
    }
}
