package StackAndQueue;

import java.util.Stack;

public class isValidDemo {


    /***
     * 匹配完的状态是，字符串遍历完了，然后对应的栈也为空；
     * @param s
     * @return
     */
    public boolean isValid(String s){
        //注意操作不要错误
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)== '('){
                //如果是左括号，就入栈对应的右括号
                stack.push(')'); //右括号入栈
            }else if (s.charAt(i) == '['){
                stack.push(']');
            }else if (s.charAt(i) == '{'){
                stack.push('}');
            }else if (stack.isEmpty() || stack.peek() !=s.charAt(i)){
                //第三中情况：有多余的右括号， 和第二种情况：有不匹配的括号情况；
                return false;
            }else {
                stack.pop(); //匹配上相等的右括号；
            }
        }
        //第一种情况：字符串遍历完了，但是有没有匹配的左括号，对应栈里面不为空
        return stack.isEmpty();
    }
}
