package LiKoHot100.树;

import java.util.Arrays;

public class searchInsertDemo {


    /**
     * 二分查找：
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert (int [] nums, int target){

        Arrays.sort(nums);
        int left =0;
        int right =nums.length-1;
        int mid = 0;
        while (left<=right){
             mid =(left + right) /2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid]> target){
                right =mid -1;
            }else {
                left = mid + 1;
            }
        }
        // 返回索引：比较中间的值，如果中间的值比target大，那么target就插入到mid位置，如果中间值比target小，就插入到mid+1;
        return  target < nums[mid]? mid : mid + 1;
    }
}
