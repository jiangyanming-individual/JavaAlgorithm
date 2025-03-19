package LiKoHot100.技巧;

import java.util.HashMap;
import java.util.Map;

public class majorityElementDemo {


    /**
     * 多数元素：
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num,hashMap.getOrDefault(num,0) +1);
        }

        Map.Entry<Integer,Integer> majortityEntry=null;

        // 遍历entry，进行打擂台
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (majortityEntry== null || entry.getValue()> majortityEntry.getValue()){
                majortityEntry = entry;
            }
        }
         return majortityEntry.getKey();
    }
}
