package StackAndQueue.two;

import java.util.*;

public class solveDemo {



//    情况1：是数，直接压nums栈；
//    情况2：是 '(' ，直接压opts栈；
//    情况3：是 ')' ，先计算opts栈中 '(' 前的操作符，然后将 '('弹出；
//    情况4：是 '+-*' ，先计算opts栈中 '(' 前的、优先级>=它的操作符，然后将它压栈；

    public int solve (String s) {
        //优先级
        Map<Character,Integer> map = new HashMap<>();    //存优先级的map
        map.put('-', 1);
        map.put('+', 1);
        map.put('*', 2);

        //双端队列
        Stack<Integer> numsQueue = new Stack<>();
        Stack<Character> opts = new Stack<>();
        // 替换空格；
        s.replaceAll(" ","");
        char[] charArray = s.toCharArray();

        for (int i=0;i<charArray.length;i++){
           char ch= charArray[i];
            //是数字的话直
            if (isNumber(ch)){
                int num=0;
                int j=i;
                // 如果是一个523这样的数的话
                while (j<charArray.length && isNumber(charArray[j])){
                    num= num * 10 + (charArray[j] -'0');
                    j++;
                }
                numsQueue.add(num);
                // 因为当前j不是数组；
                i=j-1;
            }else if (ch == '('){
                opts.add(ch);
            }else if (ch == ')'){
                // 情况3：是 ')' ，先计算opts栈中 '(' 前的操作符，然后将 '('弹出；
                while (opts.peek()!='('){
                    cal(numsQueue,opts);
                }
                //弹出'('
                opts.pop();
            }else {
                //    情况4：是 '+-*' ，先计算opts栈中 '(' 前的操作符,   优先级>=它的操作符，然后将它压栈；
                while (!opts.isEmpty() && opts.peek()!='(' && map.get(opts.peek()) >= map.get(ch)){
                    cal(numsQueue,opts);
                }
                // 加入当前的符号操作
                opts.add(ch);
            }
        }
        //判断是否还有操作符
        while (!opts.isEmpty()){
            cal(numsQueue,opts);
        }
        return numsQueue.pop();
    }
    // 判断是否是字符
    public boolean isNumber(char c){
        return  Character.isDigit(c);
    }

    /**
     * 做运算
     * @param numsQueue
     * @param opts
     */
    public void cal(Stack<Integer> numsQueue,Stack<Character> opts){
        //取出两个数进行做运算操作
        int num2 = numsQueue.pop();
        int num1=numsQueue.pop();
        //操作符
        char opt = opts.pop();
        if (opt == '*'){
            numsQueue.add(num1 * num2);
        }else if (opt == '+'){
            numsQueue.add(num1 + num2);
        }else if (opt == '-'){
            numsQueue.add(num1 - num2);
        }
    }
}
