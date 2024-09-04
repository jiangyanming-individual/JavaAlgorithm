package Array;

import java.util.Scanner;

/**
 * 寻找峰值： 当前值严格大大于左右的数：
 */
public class findPeakElementDemo {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] parts = input.split(",");
        int[] array=new int[parts.length-1];
        for (int i=0;i<array.length;i++){
            array[i]=Integer.parseInt(parts[i]);
        }
        findPeakElement(array);

    }
    public  static int findPeakElement (int[] nums) {

        int left=0;
        int right=nums.length-1;
        while (left<right){
            int mid=left + (right -left) /2;
            //可能是峰值
            if (nums[mid] > nums[mid +1]){
                right=mid;
            }else {
                left =mid + 1;
            }
        }
        return right;
    }
}


