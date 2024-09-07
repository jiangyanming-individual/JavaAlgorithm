package Array;

import java.util.Stack;

public class MyStack {


    //stack1正常出入栈
    Stack<Integer> stack1 = new Stack<Integer>();
    // stack存储最小的值，每次
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
        //栈2存放最小的值，如果当前入栈的值比栈2的小，那就直接入栈2
        if (stack2.isEmpty() || stack2.peek()> node){
            stack2.push(node);
        }else {
            // 如果还是栈2的值最小，那就继续入栈：
            stack2.push(stack2.peek());
        }


    }
    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    /**
     * 保证2的栈顶是最小的元素：
     * @return
     */
    public int min() {
        return stack2.peek();
    }
}
