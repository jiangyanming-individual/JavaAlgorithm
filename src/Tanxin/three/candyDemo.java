package Tanxin.three;

import java.util.Arrays;
import java.util.Scanner;

public class candyDemo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int [] nums=new int[n];
        for (int i=0;i<n;i++){
            nums[i]=scanner.nextInt();
        }

        candy(nums);
    }
    /**
     * 分发糖果的问题：
     * 1. 每个人至少一个糖果
     * 2. 从左往右遍历：nums[i+1] >nums[i] ，candy[i+1]= candy[i] +1;
     * 3. 从右往左遍历，保证第i个孩子既要大于左边也要大于右边 nums[i]>nums[i+1] ，candy[i] =max(candy[i+1] +1, candy[i]); d
     * @param ratings
     * @return
     */
    public static int candy(int[] ratings) {

        int[] candy=new int[ratings.length];
        Arrays.fill(candy,1);
        // 从左往右：
        for (int i=0;i<ratings.length-1;i++){

            if (ratings[i+1] >ratings[i]){
                candy[i+1] =candy[i] +1;
            }
        }

        //从右往左
        for (int i=ratings.length-2;i>=0;i--){
            if (ratings[i]>ratings[i+1]){
                //贪心策略，保证第i个孩子既要大于左边，也要大于右边。
                candy[i] =Math.max(candy[i+1] +1,candy[i]);
            }
        }

        int sum = Arrays.stream(candy).sum();
        System.out.println(sum);
        return sum;
    }
}
