package StringTest;

import java.util.Scanner;
import java.util.Stack;

public class transDemo {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()){
            String input = scanner.nextLine();
            String[] split = input.split(",");
            String str1=split[0];
            int n=Integer.parseInt(split[1]);
            trans(str1,n);
        }
    }

    public static String trans (String s, int n) {

        //  反转字符串，反转空格，大小写；
        StringBuilder stringBuilder = new StringBuilder();
        //大小写转换：
        for (int i=0;i<s.length();i++){
            if (s.charAt(i) >='a' && s.charAt(i)<='z'){
                stringBuilder.append(s.charAt(i) -'a' + 'A');
            }else if (s.charAt(i)>='A' && s.charAt(i)<='Z'){
                stringBuilder.append(s.charAt(i)-'A' + 'a');
            }else {
                //空格直接加入：
                stringBuilder.append(s.charAt(i));
            }
        }
        //反转字符串：
        reverseStr(stringBuilder,0,n-1);
        //反转单个单词
        reverseWord(stringBuilder);
        return stringBuilder.toString();
    }

    /**
     * 反转字符串：
     * @param sb
     * @param start
     * @param end
     */
    public static void reverseStr(StringBuilder  sb,int start,int end){
        while (start<end){
            //快慢指针
            char temp = sb.charAt(start);
            sb.setCharAt(start,sb.charAt(end));
            sb.setCharAt(end,temp);
            start++;
            end--;
        }
    }
    public static void reverseWord(StringBuilder sb){
        int start=0; //开始下标
        for (int i=0;i<=sb.length();i++){
            //遇到空格活着的字符串尾部，翻转
            if (start == sb.length() || sb.charAt(i) ==' '){
                reverseStr(sb,start,i-1);
            }
            //start 从空格的下一个开始
            start =start +1;
        }
    }
}
