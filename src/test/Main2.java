package test;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        int T;
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();

        for (int i=0;i<T;i++) {
            int n=scanner.nextInt();
            int [] nums=new int[n];
            for (int k=0;k<n;k++){
                nums[i]=scanner.nextInt();
            }
            int result = getResult(nums);
            System.out.println(result);
        }

        scanner.close();
    }


    public static int getResult(int[] nums){
        int result=0;

        for (int i=0;i<nums.length-1;i++){
        }
        return result + 1;
    }
}

