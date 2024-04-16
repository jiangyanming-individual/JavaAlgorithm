package StackAndQueue;

import java.util.*;

public class maxSlidingWindowDemo {

    public int[] maxSlidingWindow(int[] nums, int k){

        Queue<Integer> queue = new LinkedList<>();
        for (int i=0;i<nums.length;i++) {

            if (i>nums.length -k){
                break;
            }
            int MaxValue=Integer.MIN_VALUE;
            for (int j=i;j<k + i;j++){
                if (j>nums.length-1){
                    break;
                }
                MaxValue=nums[j] > MaxValue ? nums[j] : MaxValue;
            }
            queue.add(MaxValue);
        }

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
           list.add(queue.poll());
        }

        int[] res = new int[list.size()];
        int i=0;
        for (Integer item : list) {
            res[i++]=item;
        }
        return res;
    }
}
