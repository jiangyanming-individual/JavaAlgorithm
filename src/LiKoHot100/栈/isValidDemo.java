package LiKoHot100.栈;

import java.util.Deque;
import java.util.LinkedList;

public class isValidDemo {


    /***
     * 有效括号匹配问题： 左括号入栈， 如果是右括号，查看栈顶是否对应，不对应就返回false
     * @param s
     * @return
     */
    public boolean isValid(String s){

        // 长度为奇数直接false
        int length = s.length();
        if (length % 2 !=0){
            return false;
        }

        Deque<Character> stack=new LinkedList<>();
        for (int i=0;i<length;i++){
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }else {
                // 进行括号消除
                if (stack.isEmpty()){
                    //如果当前栈已经空了， 就意味着，没有匹配的
                    return false;
                }else if (s.charAt(i) == ')' && stack.peek() != '('){
                    return false;
                }else if (s.charAt(i) == ']' && stack.peek()!='['){
                    return false;
                }else if (s.charAt(i) == '}' && stack.peek() !='{'){
                    return false;
                }else {
                    // 符合条件
                    stack.poll();
                }
            }
        }
        // 最后判空
        return stack.isEmpty();
    }
}
