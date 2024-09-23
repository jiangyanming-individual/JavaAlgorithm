package test;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        int[] prices = new int[4];
        for (int i = 0; i < 4; i++) {
            prices[i] = scanner.nextInt();
        }
        int [] nums=new int[n];
        for (int i=0;i<n;i++){
            nums[i]=scanner.nextInt();
        }

        scanner.close();
        int res = getResult(prices,nums);
        System.out.println(res);

    }


    public static int getResult(int[] prices,int[] nums){
        int min=0;
        for (int i=0;i<nums.length;i++) {
            if (nums[i]<=prices[0]){
                min+=nums[i];
            }else {
                min+=prices[0];
            }
            if (min>=prices[0] && nums.length<=30){
                min=prices[1];
            }
        }
        return min;
    }
}

