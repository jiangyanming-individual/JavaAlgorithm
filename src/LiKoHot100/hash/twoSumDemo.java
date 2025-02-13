package LiKoHot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class twoSumDemo {


    public static void main(String[] args) {


    }

    public  int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])){
                int index = hashMap.get(target - nums[i]);
                return new int[]{i, index };
            }
            // 加入到hashmap 中
            hashMap.put(nums[i], i);
        }
        // 没有的话直接返回null
        return null;
    }
}
