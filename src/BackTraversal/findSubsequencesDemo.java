package BackTraversal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class findSubsequencesDemo {

    List<List<Integer>> result=new ArrayList<List<Integer>>();
    List<Integer> path=new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] num) {

        backtraversal(num,0);
        return result;
    }

    void backtraversal(int[] nums,int startIndex){

        if (path.size()>1){
            result.add(new ArrayList<>(path));
            //不能return
        }
        HashSet hashSet=new HashSet<Integer>(); //同一层去重复
        for (int i = startIndex; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i]< path.get(path.size()-1) || hashSet.contains(nums[i])){
                continue;
            }
            hashSet.add(nums[i]);
            path.add(nums[i]);
            backtraversal(nums,i+1);
            path.remove(path.size()-1);
        }
    }

}
