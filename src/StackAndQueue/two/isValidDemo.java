package StackAndQueue.two;

import java.util.Stack;

public class isValidDemo {

    public static void main(String[] args) {

    }

    public boolean isValid (String s) {

        if(s.length() % 2 !=0) return false;

        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (int i=0;i<charArray.length;i++){
            if (charArray[i] == '('){
                stack.push(')');
            }else if (charArray[i]=='{'){
                stack.push('}');
            }else if (charArray[i] == '['){
                stack.push(']');
            }else if (stack.isEmpty() || charArray[i] !=stack.peek()){
                //不相等或者栈提前为空了，
                return false;
            }else if (stack.peek() == charArray[i]){
                // 如果当前字符和栈顶元素相等了，出栈；
                stack.pop();
            }
        }

        // 判断栈是否为空
        return stack.isEmpty();
    }
}
