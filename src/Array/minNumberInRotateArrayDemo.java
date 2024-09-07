package Array;

import java.util.Arrays;
import java.util.Scanner;

public class minNumberInRotateArrayDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(",");
        int[] nums=new int[s.length];

        for (int i=0;i<nums.length;i++){
            nums[i]=Integer.parseInt(s[i]);
        }

        int i = minNumberInRotateArray(nums);
        System.out.println(i);
    }

    public  static  int minNumberInRotateArray (int[] nums) {

        //求旋转点是数组中最小的值： 二分法
        int left =0;
        int right= nums.length-1;
        while (left<right){
            //找到中间点
            int mid= (left + right) /2;
            // 在[mid+1,right]
            if (nums[mid]>nums[right]){
                left=mid+1;
            }else if (nums[mid]<nums[right]){
                //[left,mid]
                right=mid;
            }else{
                // 缩小范围
                right--;
            }
        }
        //最后left == right;
        return nums[left];
    }
}
