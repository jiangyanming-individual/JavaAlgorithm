package DoublePointer;

public class removeElementDemo {

    public int removeElement(int[] nums,int val){


        int slow=0;
        for (int fast=0;fast<nums.length;fast++){

            if (nums[fast]!=val){
                //跳过val;
                nums[slow]=nums[fast];
                slow++;
            }

        }
        return slow; //slow是个数
    }
}
