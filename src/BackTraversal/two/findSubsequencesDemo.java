package BackTraversal.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * 1. 需要去重复但是不能去排序，因为要求的是按照数组的先后顺序来进行组合
 * 2. 需要取树上每一个节点，而不是叶子节点
 * 3. 这里可以使用hashMap去重复，统计使用过元素的个数；
 */
public class findSubsequencesDemo {

    List<List<Integer>> result=new ArrayList<>();
    List<Integer> path=new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] num) {

        backtraversal(num,0);
        return result;
    }

    public void backtraversal(int [] nums, int startIndex){
        if (path.size()>1){
            result.add(new ArrayList<>(path));
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        // for 循环是同一层：
        for (int i=startIndex;i<nums.length;i++){
            //递减
            if (!path.isEmpty() && nums[i]<path.get(path.size()-1)){
                continue;
            }
            if (map.getOrDefault(nums[i],0)>=1){
                // 说明同一层已经使用过了
                continue;
            }
            // 仅是记录元素是否被使用
            map.put(nums[i],map.getOrDefault(nums[i],0) +1);
            path.add(nums[i]);
            backtraversal(nums,i+1);// 下一层
//            map.put(nums[i],map.getOrDefault(nums[i],0) -1);
            path.remove(path.size()-1);
        }
    }
}
