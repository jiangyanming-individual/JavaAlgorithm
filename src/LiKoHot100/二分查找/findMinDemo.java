package LiKoHot100.二分查找;

public class findMinDemo {


    /***
     * 寻找旋转排序数组中的最小值： 最小值左侧节点严格大于右侧最大值， 最小值右边节点严格小于右侧最大值
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int low=0;
        int hight= nums.length-1;

        while (low<=hight){
            int mid = (low + hight ) /2;
            if (nums[mid]<nums[hight]){
                hight=mid-1;
            }else {
                // mid在左侧，
                low= mid+1;
            }
        }
        return nums[low];
    }
}
