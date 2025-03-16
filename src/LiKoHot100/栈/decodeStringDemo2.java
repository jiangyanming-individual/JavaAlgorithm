package LiKoHot100.栈;

import DpQuestion.two.Demo;

import java.util.Deque;
import java.util.LinkedList;

public class decodeStringDemo2 {

    /**
     * 解码操作： 主要数字栈和字符串栈
     * @param s
     * @return
     */
    public String decodeString(String s){

        Deque<Integer> numberStack= new LinkedList<>();
        Deque<String> strStack= new LinkedList<>();
        // 倍数
        int k= 0;
        // 当前字符串：
        String currentString ="";
        // 遍历字符串
        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)){
                k= k * 10 + (ch - '0');
            }else if (ch == '['){
                //入栈：
                numberStack.push(k);
                strStack.push(currentString);
                // 重置k 和当前字符；
                k=0;
                currentString="";
            }else if (ch == ']'){
                // 解码
                int  number = numberStack.poll();
                String poll = strStack.poll();
                StringBuffer stringBuffer = new StringBuffer(poll);
                for (int i=0;i<number;i++){
                    stringBuffer.append(currentString);
                }
                // 给当前字符串进行赋值操作：
                currentString = stringBuffer.toString();
            }else {
                // 如果是字符就进行拼接操作：
                currentString += ch;
            }
        }
        // 返回最终的结果
        return currentString;
    }
}
