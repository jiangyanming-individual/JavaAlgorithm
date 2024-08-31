package monotonicStack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 单调栈第一题
 */
public class dailyTemperaturesDemo {


    /**
     * 每日温度
     * @param temperature
     * @return
     */
    public int[] dailyTemperature(int[] temperature){

        int[] result=new int[temperature.length-1];
        //初始化一个栈：
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        for (int i=1;i<temperature.length;i++){
            //如果当前元素小于等于栈中的元素，直接入栈，因为要保证栈是单调递增的；
            if (temperature[i]<=temperature[stack.peek()]){
                stack.add(i);
            }else {
                // 如果当前元素大于栈中元素，栈的元素出栈，并计算result
                while (!stack.isEmpty() && temperature[i]>temperature[stack.peek()]){
                    result[stack.peek()] = i-stack.peek();
                    stack.pop();
                }
                //然后当前元素还要加入到栈中；
            }
        }
        return result;
    }
}
