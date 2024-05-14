package Tanxin;

import java.util.Map;

public class maxSubArrayDemo {

    public int maxSubArray(int[] nums) {
        //只有一个元素直接返回nums[0]
        if (nums.length == 1){
            return nums[0];
        }
        int sum=0;
        int result=Integer.MIN_VALUE;
        //只要相加为负数，就直接重新开始
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            result= Math.max(sum,result);
            if (sum <=0){
                sum =0;
            }
        }
        return result;
    }

}
