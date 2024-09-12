package BackTraversal.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permuteDemo {


    /**
     * 全排列的问题:
     * 1. 递归终止条件： path.size= nums.size();
     * 2. 取叶子节点元素，
     * 3. 排列问题[1,2] 和 [2,1]是不一样的两个元素；
     * 4. 需要使用used[i] used[i]==true 表示已经用过了
     *
     * @param nums
     * @return
     */

    List<List<Integer>> result=new ArrayList<>();
    List<Integer> path=new ArrayList<>();

    public List<List<Integer>>  permute(int[] nums){
        if (nums.length == 0) return result;
        boolean[] used=new boolean[nums.length];
        Arrays.fill(used,false);
        backtracking(nums,used);
        return result;
    }

    /**
     * 回溯：
     * @param nums
     * @param
     */
    public void backtracking(int[] nums,boolean[] used){

        if (path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i=0;i<nums.length;i++){
            // 如果已经有了元素，就直接跳过
            if (used[i]){
                continue;
            }
            used[i]=true;
            path.add(nums[i]);
            backtracking(nums, used);
            used[i]=false;
            path.remove(path.size()-1);
        }

    }
}
