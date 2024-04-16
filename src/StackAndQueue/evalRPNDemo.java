package StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class evalRPNDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens={"2","1","+","3","*"};
        evalRPN(tokens);
    }
    public static int evalRPN(String[] tokens){

        Stack<Integer> stack = new Stack<>();
        if (tokens.length == 0){
            return 0;
        }
        for (int i=0;i<tokens.length;i++){

            if (tokens[i].equals("+")){
                int num1=stack.pop();
                int num2=stack.pop();
                stack.push(num2 + num1);
            }else if (tokens[i].equals("-")){
                int num1=stack.pop();
                int num2=stack.pop();
                stack.push(num2 - num1);
            }else if (tokens[i].equals("*")){
                int num1=stack.pop();
                int num2=stack.pop();
                stack.push(num2 * num1);
            }else if (tokens[i].equals("/")){
                int num1=stack.pop();
                int num2=stack.pop();
                stack.push(num2 / num1);
            }else {
                //遇到数字直接进栈
                stack.push(Integer.parseInt(tokens[i]));//String ===》 int
            }
        }
        return stack.pop();
    }
}
