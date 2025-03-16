package LiKoHot100.二分查找;

public class searchRangeDemo {

    /**
     * 查找元素的第一个和最后一个位置： 思想就是还是二分查找，找到第一个target, 就继续左右进行遍历操作
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums,int target){

        return binarySearch(nums,target);
    }
    public int[] binarySearch(int[] nums,int target){

        int left =0;
        int right= nums.length-1;
        int n=nums.length;
        while (left<=right){
            int mid =(left + right) /2;
            if (nums[mid] == target){
                int l =mid, r= mid;
                while (l>=0 && nums[l] == target) l--;
                while (r<n&& nums[r] == target) r++;
                return new int[]{l+1, r-1};
            }else if(nums[mid]> target){
                right =mid-1;
            }else {
                left =mid + 1;
            }
        }
        // 没有结果的话，直接返回-1；
        return new int[]{-1,-1};
    }
}
