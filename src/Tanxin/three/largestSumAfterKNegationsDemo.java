package Tanxin.three;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class largestSumAfterKNegationsDemo {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n=scanner.nextInt();
        int k=scanner.nextInt();
        int [] nums=new int[n];
        for (int i=0;i<nums.length;i++){
            nums[i]=scanner.nextInt();
        }
        largestSumAfterKNegations(nums,k);
    }
    /**
     * K次后翻转，
     *
     * 1. 按照绝对值进行降序操作；
     * 2. 遍历数组，如果当前值小于0 并且k>0， 直接进行翻转
     * 3. 如果最后K还有剩余，如果是奇数的，直接返回最后一个小的元素，偶数的话还是正常的。
     * 4. 最后求和
     *
     * @param nums
     * @param k
     * @return
     */
    public  static int largestSumAfterKNegations(int[] nums, int k) {

        int[] array = Arrays.stream(nums).boxed().sorted(new Comparator<Integer>() {
            // 降序：
            @Override
            public int compare(Integer o1, Integer o2) {
                int abs1=Math.abs(o1);
                int abs2=Math.abs(o2);
                return abs2 -abs1;
            }
        }).mapToInt(Integer::intValue).toArray();

        for (int i=0;i<array.length;i++){

            if (array[i]<0 && k>0){
                array[i]=-array[i];
                k--;
            }
        }

        // k剩余为奇数：
        if (k % 2 ==1){
            array[array.length-1] =- array[array.length-1];
        }
        int sum = Arrays.stream(array).sum();
        System.out.println(sum);
        return sum;
    }
}
