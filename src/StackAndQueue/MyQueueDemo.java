package StackAndQueue;

import java.util.Stack;

public class MyQueueDemo {


    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    /**
     * 初始化栈：
     */
    public MyQueueDemo() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    /**
     * 进栈
     * @param x
     */
    public void push(int x) {
        stackIn.push(x);
    }

    /**
     * 只有输出栈为空，才会将输入栈的元素导入的输出栈；
     * @return
     */
    public int pop() {
        //如果输出栈为空
        if (stackOut.isEmpty()){
            while (!stackIn.isEmpty()){
                Integer pop = stackIn.pop();
                stackOut.push(pop);
            }
        }
        //如果输出栈不为空，直接删除
        return stackOut.pop();
    }

    /**
     * 查看队列对头
     * @return
     */
    public int peek() {
        int pop = this.pop();
        stackOut.push(pop);// 将删除的栈顶元素，再压回到栈
        return stackOut.peek();
    }

    /**
     * 进栈和出栈同时为空
     * @return
     */
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
}
