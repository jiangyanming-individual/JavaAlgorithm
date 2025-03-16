package BackTraversal.three;

import java.util.ArrayList;
import java.util.List;

public class subsetsDemo {

    /**
     * 1.子集问题： 收取的是节点的元素，所以没有结束条件，只管加就行, startIndex>=nums.length;
     * 2. result 只管加path:
     * 3. i从startIndex开始
     */
    List<List<Integer>> result=new ArrayList<>();
    List<Integer> path=new ArrayList();

    public List<List<Integer>> subsets(int[] nums) {

        if (nums.length == 0) return result;
        traversal(nums,0);
        return  result;
    }

    public void traversal(int[] nums,int startIndex){
        // 不断的加
        result.add(new ArrayList<>(path));

        // 回溯终止条件；
        if (startIndex>=nums.length){
            return;
        }
        // i从startIndex开始
        for (int i=startIndex;i<nums.length;i++){
            path.add(nums[i]);
            traversal(nums,i+1);// 下一层；
            path.remove(path.size()-1);
        }
    }

}
