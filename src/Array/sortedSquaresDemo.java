package Array;

import java.util.Scanner;

public class sortedSquaresDemo {


    /**
     * 有序数组的平方： 快慢指针
     * @param args
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        String[] split = s.split(",");

        int[] nums=new int[split.length];
        for (int i=0;i<split.length;i++){
            nums[i]=Integer.parseInt(split[i]);
        }
        //排序
        sortedSquares(nums);
    }

    public static int[] sortedSquares(int[] nums) {

        int start=0;
        int end = nums.length-1;
        int[] result=new int[nums.length];
        int index=nums.length-1;

        while (start<=end){
            //如果遇到负数变大，直接交换：
            if (nums[start] * nums[start]> nums[end] * nums[end]){
                result[index--] =nums[start] * nums[start];
                start++;
            }else {
                //原本的正数是不用变的：
                result[index--]= nums[end] * nums[end];
                end--;
            }
        }

        for (int num : result) {
            System.out.println(num);
        }
        return nums;
    }
}
