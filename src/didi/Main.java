package didi;

import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String args[]) {
        int n, m;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        scanner.close();
        int res = getMax(nums, m);
        System.out.println(res);

    }

    public static int getMax(int[] nums, int m) {

        int max=Integer.MIN_VALUE;
        int sum=0;
        int start=0;
        int count=0;

        int total = Arrays.stream(nums).sum();
        if (total<=m) return nums.length;

        for (int i=0;i<nums.length;i++){

            sum+=nums[i];
            //更新最大的
            if (sum>=m){
                // 更新最大的start 和 max
                max=Math.max(max,count);
                count=0;
                sum=0;
            }else {
                count++;
            }
        }
        return max;
    }
}

