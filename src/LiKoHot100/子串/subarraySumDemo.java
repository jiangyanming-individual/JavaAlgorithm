package LiKoHot100.子串;

import java.util.HashMap;

public class subarraySumDemo {


    public int subarraySum(int[] nums, int k) {

        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            // 移动求和
            for (int end = start; end >= 0; end--) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }


    public int subarraySum2(int[] nums, int k) {

        int count = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);  // key是前缀和为0的的个数
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            //看前面是否满足有前缀和为preSum的个数
            if (hashMap.containsKey(preSum - k)) {
                count += hashMap.get(preSum - k);
            }
            // 没有的话就将前面的前缀和进行存储，key是和，value是个数
            hashMap.put(preSum, hashMap.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}
