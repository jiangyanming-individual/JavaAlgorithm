package demo;

import java.util.Scanner;
import java.util.Stack;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String s = scanner.nextLine();
        boolean valid = isValid(s);
        System.out.println(valid);
    }

    public static boolean isValid(String s){

        Stack<Character> stack = new Stack<>();
        if (s.length() % 2 !=0){
            return false;
        }
        for (int i=0;i<s.length();i++){
            if(stack.isEmpty()){
                return false;
            }else if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }else if (s.charAt(i) == ')' && stack.peek().equals('(')){
                stack.pop();
            }else if (s.charAt(i) == '}' && stack.peek().equals('{')){
                stack.pop();
            }else if (s.charAt(i) == ']' && stack.peek().equals('[')){
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}
