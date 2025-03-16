package LiKoHot100.子串;

public class minSubArrayLenDemo {


    /**
     * 长度最小的子数组： 滑动窗口+ 双指针的思想
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {

        int left =0;
        int sum =0;
        int result =Integer.MAX_VALUE;
        for (int right =0;right<nums.length;right++){
            sum+=nums[right];
            // 如果sum 大于target，就将左指针右移动
            while (sum>= target){
                sum-= nums[left];
                // 更新最小的范围
                result= Math.min(result, (right -left +1));
                // 左指针移动
                left++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

}
