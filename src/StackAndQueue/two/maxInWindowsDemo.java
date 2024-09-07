package StackAndQueue.two;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class maxInWindowsDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();

        int[] nums=new int[n];
        for (int i=0;i<n;i++){
            nums[i]=scanner.nextInt();
        }
        int size= scanner.nextInt();
        System.out.println("size:" + size);
        List<Integer> list = maxInWindows(nums, size);
        for (Integer i : list) {
            System.out.print(i);
            System.out.print(" ");
        }
    }

    public  static List<Integer> maxInWindows (int[] num, int size) {

        if (num.length <size || size == 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for (int i=0;i<=num.length-1;i++) {
            int max=Integer.MIN_VALUE;
            //越界
            if ((i + size -1) > num.length-1){
                System.out.println(i+size -1);
                break;
            }
            //每次获取滑动窗口的最大值
            for (int j=i;j<= (i + size-1);j++){
                if (num[j]> max){
                    max=num[j];
                }
            }
            res.add(max);
        }
        return res;
    }
}
