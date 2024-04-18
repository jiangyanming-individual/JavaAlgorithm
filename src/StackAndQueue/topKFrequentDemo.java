package StackAndQueue;

import java.util.*;

public class topKFrequentDemo {

    public int[] topKFrequent(int[] nums,int k){

        //使用hashmap对key进行计数
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i=0;i< nums.length;i++){
            hashMap.put(nums[i],hashMap.getOrDefault(nums[i],0)+1);
        }

        // 2.使用优先级队列；存入的是一个数组 ；需要自定义比较器：按出现频率降序的方式排列；
        //优先级队列，默认需要有一个比较器；
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((pair1,pair2)-> pair2[1]-pair1[1]);
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            priorityQueue.add(new int[]{entry.getKey(),entry.getValue()}); //[key,count];
        }

        int[] res = new int[k];

        for (int i=0;i<k;i++){
            res[i]=priorityQueue.poll()[0];// 弹出队头，加入到k;
        }

        return res;
    }
}
