package Array;

import java.util.Stack;

public class MyQueue {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {

        stack1.push(node);
    }
    public int pop() {
        // 先判断栈2 是否为空，如果为空的话，在判断栈1是否为空，如果不为空，栈1弹出元素加入到栈2中
        while (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }




}
