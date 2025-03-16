package LiKoHot100.栈;

import java.util.Deque;
import java.util.LinkedList;

public class MinStackDemo {
    Deque<Integer> stack;
    //辅助栈实现
    Deque<Integer> minStack;
    public MinStackDemo() {
         stack=new LinkedList<>();
         minStack= new LinkedList<>();
         // 放入最大的
         minStack.push(Integer.MAX_VALUE);
    }
    public void push(int val) {
        stack.push(val);
        // 放入比较小值，保证最小栈的栈顶是栈的最小值
        minStack.push(Math.min(minStack.peek(),val));
    }
    public void pop() {
        stack.poll();
        minStack.poll();
    }

    // 返回栈顶元素：
    public int top() {
        return stack.peek();
    }

    // 获取到最小的元素：
    public int getMin() {
        return minStack.peek();
    }
}
