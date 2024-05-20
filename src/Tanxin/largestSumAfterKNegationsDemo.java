package Tanxin;

import java.util.Arrays;

public class largestSumAfterKNegationsDemo {

    public int  largestSumAfterKNegations(int[] nums, int k) {
//        第一步：将数组按照绝对值大小从大到小排序，注意要按照绝对值的大小
//        第二步：从前向后遍历，遇到负数将其变为正数，同时K--
//        第三步：如果K还大于0，那么反复转变数值最小的元素，将K用完
//        第四步：求和
        int sum=0;
        int temp=0;
        //冒泡排序
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<nums.length-i-1;j++){
                if (Math.abs(nums[j])< Math.abs(nums[j+1])){
                    temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
        for (int i=0;i<nums.length;i++){

            if (k>0 && nums[i]<0){
                nums[i] =-1 * nums[i];
                k--;
            }
        }
        //如果最后的k 是奇数的话，就一直取反最后一个,因为可以对同一个元素操作多次
        if (k % 2 !=0){
            nums[nums.length -1] =nums[nums.length-1] * -1;
        }
        return  Arrays.stream(nums).sum();
    }
}
