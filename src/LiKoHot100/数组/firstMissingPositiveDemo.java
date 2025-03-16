package LiKoHot100.数组;

import java.util.Arrays;

public class firstMissingPositiveDemo {


    /**
     * 缺失的第一个正整数，
     * 先遍历数组长度，然后使用二分查找的方法进行，返回元素。
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {

        Arrays.sort(nums);
        int len =nums.length;
        for (int i = 1; i <= nums.length; i++) {
            int res = binarySearch(nums, i);
            // 找不到的情况下就直接返回当前的数
            if (res == -1) {
                return i;
            }
        }
        //不满足的情况下就直接返回len +1
        return len +1;
    }
    public int binarySearch(int[] nums, int target){

        int left =0;
        int right= nums.length-1;
        while (left<=right){

            int mid =(left + right) /2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid]> target ){
                mid = right-1;
            }else {
                mid= left+1;
            }
        }
        // 不满足条件
        return -1;

    }
}
