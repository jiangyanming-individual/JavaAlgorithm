package LiKoHot100.栈;

import java.util.Deque;
import java.util.LinkedList;

public class decodeStringDemo {


    /**
     *
     * 字符串解码
     * @param s
     * @return
     */
    public String decodeString(String s){

        //数字栈
        Deque<Integer> DigitStack= new LinkedList<>();
        // 字符栈
        Deque<String> StringStack= new LinkedList<>();
        // 倍数
        int k=0;
        // 当前字符串
        String currentString = "";

        for (char ch : s.toCharArray()) {
            // 入数字栈
            if (Character.isDigit(ch)) {
                // 将数字字符串改为数字
                k = k * 10 + (ch - '0');
            }else if (ch == '['){
                // 入栈
                DigitStack.push(k);
                //当前字符串是有值的话，直接入栈
                StringStack.push(currentString);
                // 重置字符串和数字
                currentString="";
                k=0;
            }else if (ch == ']'){
                // 解码
                int number = DigitStack.poll();
                // 将之前括号外的字符进行拼接
                StringBuffer tempString = new StringBuffer(StringStack.poll());
                for (int i=0;i<number;i++){
                    // 拼接当前的字符
                    tempString.append(currentString);
                }
                // 将字符串存储到currentString中
                currentString= tempString.toString();
            }else {
                //如果是括号里面的字符的话，直接进行拼接操作
                currentString+= ch;
            }
        }
        // 返回结果：
        return currentString;
    }
}
