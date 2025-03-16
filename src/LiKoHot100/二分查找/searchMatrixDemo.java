package LiKoHot100.二分查找;

public class searchMatrixDemo {


    public boolean searchMatrix(int[][] matrix, int target){
        for (int[] nums : matrix) {
            int res= binarySearch(nums, target);
            // 不等于-1说明找到了mid
            if (res!=-1){
                return true;
            }
        }
        return false;
    }

    /**
     * 返回索引
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch(int[] nums, int target){

        int left =0;
        int right =nums.length-1;

        while (left<=right){
            int mid = (left + right) /2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] >target){
                right =mid-1;
            }else {
                left= mid +1;
            }
        }
        return -1;
    }
}
