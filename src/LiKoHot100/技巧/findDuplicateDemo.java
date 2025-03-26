package LiKoHot100.技巧;

import java.util.HashSet;

public class findDuplicateDemo {


    /**
     * 使用hashset
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)){
                return num;
            }
            // 加入num
            set.add(num);
        }
        return -1;
    }
}
