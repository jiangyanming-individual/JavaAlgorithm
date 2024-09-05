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


        StringBuffer res=new StringBuffer();
        for(int i = 0; i < n; i++){
            //大小写转换
            if(s.charAt(i) <= 'Z' && s.charAt(i) >= 'A')
                res.append((char)(s.charAt(i) - 'A' + 'a'));
            else if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                res.append((char)(s.charAt(i) - 'a' + 'A'));
            else
                //空格直接复制
                res.append(s.charAt(i));
        }
        //反转字符串：
        StringBuffer stringBuffer = res.reverse();

        for (int i=0;i<n;i++){
            // 找到空格：
            int end=i;
            while (end<n && stringBuffer.charAt(end) !=' '){
                end++;
            }
            String substring = res.substring(i, end);  // end 取不到
            StringBuffer buffer = new StringBuffer(substring);
            // 翻转单个单词；
            String word = buffer.reverse().toString();
            res.replace(i,end,word);
            //重新找新的单词：
            i=end;
        }
        System.out.println(res);
        return res.toString();
    }

    /**
     * 反转字符串：
     * @param sb
     * @param start
     * @param end
     */
    public static void reverseStr(StringBuilder sb,int start,int end){
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
        int end=1; // 多加1
        int n = sb.length();
        while (start<n){
            while (end<n && sb.charAt(end)!=' '){
                end++;
            }
            reverseStr(sb,start,end-1);
            start=end+1;
            end=start+1;
        }
    }
}
