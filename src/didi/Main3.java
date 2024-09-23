package didi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main3 {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums=new int[n];
        for (int i=0;i<n;i++){
            nums[i]=scanner.nextInt();
        }
        scanner.close();
        int answer = answer(nums);
        System.out.println(answer);
        int[] result = getResult(answer);
        System.out.println(result);
        int max = getMax(result);
        System.out.println(max);
    }

    public static int answer(int[] x) {


        int n=x.length;
        int index=0;
        int count=1;
        while (n>1){
            if (count == 4){
                for (int i=index;i<n-1;i++){
                    x[i]=x[i+1];
                }
                n--;
                count=1;
                if (index == n){
                    index=0;
                }
            }else {
                index++;
                count++;
                if (index == n){
                    index=0;
                }
            }
        }
        return x[0];
    }

    public static int[] getResult(int n){

        // 计算
        long factor=calculate(Math.abs(n));
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=1;i<=factor;i++){
            if (factor % i ==0){
                list.add(i);
            }
        }

        int [] result= new int[Math.min(4,list.size())];
        for (int i=0;i< result.length;i++){
            result[i] =list.get(i);
        }
        return result;
    }


    public static long calculate(int n){

        long result=1;
        for (int i=2;i<=n;i++){
            result *=i;
        }
        return result;
    }


    public static int getMax(int [] nums){

        int left=0;
        int right= nums.length -1;

        int max=0;
        while (left<right){
            int area=Math.min(nums[left],nums[right] * (right -left));
            max=Math.max(max,area);
            if (nums[left]<nums[right]){
                left++;
            }else {
                right--;
            }
        }

        return max;
    }
}
