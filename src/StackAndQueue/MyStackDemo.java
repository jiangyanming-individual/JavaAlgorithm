package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class MyStackDemo {


    Queue<Integer> queueIn; //只使用一个也可以
    Queue<Integer> queueOut;
    public MyStackDemo() {
        queueIn=new LinkedList<>();
        queueOut=new LinkedList<>();
    }

    public void push(int x) {
        queueIn.add(x);//加入一个元素
    }

    public int pop() {
        if (!queueIn.isEmpty()){
            int size=queueIn.size();
            int count=0;
            while (count<size-1){
                Integer poll = queueIn.poll();//删除队头
                queueIn.add(poll);//将对头加入到队尾；
                count++;
            }
            //删除栈顶元素
            return queueIn.poll();
        }
        return -1; //为空返回-1；
    }

    public int top() {
        int pop = this.pop(); //先删除拿到最后的一个元素，
        queueIn.add(pop); //然后再加入到队尾；
        return pop;
    }

    public boolean empty() {
        return queueIn.isEmpty();
    }
}
