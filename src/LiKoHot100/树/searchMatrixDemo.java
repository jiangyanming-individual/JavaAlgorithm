package LiKoHot100.树;

public class searchMatrixDemo {


    /**
     * 二分查找: 先找到对应的行， 然后再遍历行
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target){
        int rowIndex = binarySearchRow(matrix, target);
        return binarySearch(matrix[rowIndex],target);
    }

    public int binarySearchRow(int[][] nums, int target){

        int left =0;
        int right =nums.length-1;
        while (left<=right){
            int mid =(left + right) /2;
            if (nums[mid][0] <= target) {
                left = mid;
            }else {
                right=mid-1;
            }
        }

        return left;
    }

    public boolean binarySearch(int[] nums,int target){

        int left =0;
        int right =nums.length-1;
        while (left<=right){

            int mid =(left + right) /2;
            if (nums[mid] == target){
                return true;
            }else if (nums[mid]<target){
                left =mid + 1;
            }else {
                right=mid - 1;
            }
        }
        return false;
    }
}
