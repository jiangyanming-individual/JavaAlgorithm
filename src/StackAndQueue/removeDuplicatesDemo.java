package StackAndQueue;

import java.util.Stack;

public class removeDuplicatesDemo {

    public String removeDuplicates(String s){

        Stack<Character> stack = new Stack<>();

        if (s.length() == 0){
            return null;
        }
        //使用栈的思想
        for (int i=0;i<s.length();i++){
            if (stack.isEmpty() || stack.peek() !=s.charAt(i)){
                stack.push(s.charAt(i));
            }
            stack.pop();
        }

        //拼接字符；
        String resStr="";
        while (!stack.isEmpty()){
            resStr=stack.pop() +resStr; //abc
        }

        return resStr;

    }

}



