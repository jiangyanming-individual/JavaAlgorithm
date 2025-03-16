package LiKoHot100.hash;

import java.util.HashSet;

public class longestConsecutiveDemo {


    /**
     * 优先找到开头的那个元素，然后进行统计个数
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {

        // 使用hashset去重
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        int resultCounts= 0;

        // 遍历hashset:
        for (int num : hashSet){
            // 当前的数是开头第一数
            if (!hashSet.contains(num -1)){
                int currentNum= num;
                // 当前数开头的序列长度
                int currentCounts= 1;
                // 一直遍历到这个开头的序列结束
                while (hashSet.contains(currentNum + 1)){
                    currentNum ++;
                    currentCounts++;
                }
                // 更新最长的序列长度
                resultCounts = Math.max(resultCounts, currentCounts);
            }
        }
        return resultCounts;
    }
}
