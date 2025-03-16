package LiKoHot100.矩阵;

public class searchMatrixDemo {


    /**
     * 搜索二维矩阵： 从左到右升序，从上到下是升序的
     * 1. 直接进行查找，
     * 2. 对每一行的数组进行二分查找：
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] nums : matrix) {
            int res =binarySearch(nums, target);
            if (res != -1) {
                return true;
            }
        }
        return false;
    }

    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch(int[] nums, int target){
        int left =0;
        int right= nums.length-1;

        while (left<=right){
            int mid =(left + right) /2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid]>target){
                right= mid-1;
            }else {
                left=mid+1;
            }
        }
        return  -1;
    }
}
