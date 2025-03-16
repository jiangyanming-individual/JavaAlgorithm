package LiKoHot100.二分查找;

public class searchDemo {


    /**
     * 二分搜索： 部分有序查找操作
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums,int target){
        int n= nums.length;
        if (n == 0){
            return -1;
        }
        if (n ==1){

            return nums[0] == target ? 0 : -1;
        }

        int left =0;
        int right = n-1;

        while (left<=right){

            int mid = (left + right)/2;
            // 如果特殊情况，中间值刚好满足：
            if (nums[mid] == target){
                return mid;
            }
            if (nums[0]<=nums[mid]){
               // 左半边有序；
                if (nums[0]<=target && target<nums[mid]){
                    right =mid -1;
                }else {
                    left= mid +1;
                }
            }else {
                // 右半边有序：先查询右边
                if (nums[mid]<target && target<= nums[n-1]){
                    left= mid +1;
                }else {
                    // 查询左边：
                    right= mid-1;
                }
            }
        }
        return -1;
    }
}
