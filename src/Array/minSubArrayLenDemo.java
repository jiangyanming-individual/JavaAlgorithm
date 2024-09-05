package Array;

import java.util.Scanner;

public class minSubArrayLenDemo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int target= scanner.nextInt();
        //去掉回车符；
        scanner.nextLine();
        String input = scanner.nextLine();
        String[] split = input.split(",");
        int[] nums=new int[split.length];
        for (int i=0;i<nums.length;i++){
            nums[i]=Integer.parseInt(split[i]);
        }

        minSubArrayLen(target,nums);
    }

    public static int minSubArrayLen(int target, int[] nums) {


        int start=0;
        int result=Integer.MAX_VALUE;
        int subLength=0;
        int sum=0;
        for (int end=0;end<nums.length;end++){

            sum+=nums[end];
            //如果当前窗口大于target了, 每次都更新窗口
            while (sum>=target){
                // 每次页更新子串长度
                subLength = end -start +1;
                result = Math.min(subLength, result);
                // start前移
                sum-=nums[start++];
            }
        }
        System.out.println(result == Integer.MAX_VALUE ? 0: result);
        return result == Integer.MAX_VALUE ? 0: result;
    }

    public void  fun(int n){

        int sum=0;
        while (sum<n){
            sum+=sum * 2 ;
        }
    }

}
