package LiKoHot100.技巧;

import java.util.HashMap;

public class singleNumberDemo {


    /**
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums){
        int res= 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num,hashMap.getOrDefault(num,0) +1);
        }

        for (int num:nums){
            if (hashMap.get(num)== 1){
                res = num;
            }
        }
        return res;
    }
}
