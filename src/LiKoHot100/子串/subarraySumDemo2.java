package LiKoHot100.子串;

import java.util.HashMap;

public class subarraySumDemo2 {


    /**
     * 和为k的子数组
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int count =0;

        for (int start =0 ;start<nums.length;start++) {
            int sum = 0;
            // 倒序统计求和
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
        int count =0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0,1); // 前缀和为0的有1个数

        int preSum=0;
        for (int i = 0; i < nums.length; i++) {

            preSum+= nums[i];
            // 前缀和
            if (hashMap.containsKey(preSum - k)){
                count+= hashMap.get(preSum - k);
            }
            hashMap.put(preSum, hashMap.getOrDefault(preSum,0) + 1);
        }
        return count;
    }
}
