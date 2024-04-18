package StackAndQueue;

import java.util.*;



class MyQueue{

    Deque<Integer> deque = new LinkedList<>();
    //删除队头元素
    void poll(int val){
        if (!deque.isEmpty() && val == deque.peek()){
            deque.poll();
        }
    }

    //添加元素
    void push(int val){
        //删除队列中所有比val小的元素
        while (!deque.isEmpty() && val>deque.getLast()){
            deque.removeLast();
        }
        deque.add(val);
    }
    //得到最大值,保证队头是最大的元素
    int getPeek(){
        return deque.peek();
    }
}


public class maxSlidingWindowDemo {

    public int[] maxSlidingWindow(int[] nums, int k){

        MyQueue myQueue = new MyQueue();

        int len=nums.length-k + 1;//最后的结果长度；
        int[] res = new int[len];
        int count=0;
        //加入前k个元素
        for (int i=0;i<k;i++){
            myQueue.push(nums[i]);
        }
        //得到前k个中最大的元素
        res[count++]=myQueue.getPeek();

        for (int i=k;i< nums.length;i++){
            //删除队头；
            myQueue.poll(nums[i-k]);
            //加入队尾；
            myQueue.push(nums[i]);
            //得到窗口最大值；
            res[count++]=myQueue.getPeek();
        }
        return res;
    }
}
