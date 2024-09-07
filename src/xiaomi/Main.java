package xiaomi;

import java.util.*;
public class Main {

    public static void main(String args[]){
            int n;
            Scanner scanner = new Scanner(System.in);
            n=scanner.nextInt();

            int[] nums=new int[n];
            for (int i=0;i<n;i++){
                nums[i]=scanner.nextInt();
                System.out.println(nums[i]);
            }
        int[] res = getMin(nums);

        // 输出
        for (int i : res) {
            System.out.print(i);
            System.out.print(" ");
        }
        scanner.close();
    }

    public static int[] getMin(int[] nums){



        return nums;
    }



}

