package Array;

import java.util.Scanner;

/**
 * 二分查找
 */
public class searchDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] parts = input.split(",");
        int[] array=new int[parts.length-1];

        for (int i=0;i<array.length;i++){
            array[i]=Integer.parseInt(parts[i]);
        }
        int target=Integer.parseInt(parts[parts.length-1]);
        search(array,target);
    }


    public static int search (int[] nums, int target) {
        // write code here

        int left=0;
        int right= nums.length-1;

        while (left<=right){
            // 更新mid
            int mid =left + (right - left)/2;
            if (nums[mid]>target){
                right=mid-1;
            }else if (nums[mid]<target){ // mid 等号不能取值：
                left= mid + 1;
            }else {
                System.out.println("下标是：" + mid);
                return mid;
            }
        }
        //没有找到：
        return -1;
    }
}


