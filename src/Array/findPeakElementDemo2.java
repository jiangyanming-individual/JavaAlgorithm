package Array;

public class findPeakElementDemo2 {
    public static void main(String[] args) {



    }

    public  static int findPeakElement (int[] nums) {

        int left=0;
        int right= nums.length -1;

        while (left<right){
            int mid =left + (right -left) /2;
            if (nums[mid]>nums[mid +1]){
                right=mid;
            }else {
                // 往右肯定能找到峰值
                left=mid+1;
            }
        }
        return right;
    }
}

