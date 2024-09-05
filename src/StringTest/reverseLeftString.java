package StringTest;

import java.util.Scanner;

public class reverseLeftString {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt();
        //清除换行符：
        scanner.nextLine();
        //输入一串字符：
        String s = scanner.nextLine();
        reverseLeftString(s,n);
    }

    public static String reverseLeftString(String s,int k){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<s.length();i++){
            stringBuilder.append(s.charAt(i));
        }
        // 反转sb
        StringBuilder sb = stringBuilder.reverse();
        System.out.println(sb.charAt(0));
        //翻转前k个
        reverseK(sb,0,k-1);
        //剩余字符
        reverseK(sb,k,sb.length()-1);
        System.out.println(sb.toString());
        return sb.toString();
    }

    // 双指针反转；
    public static void reverseK(StringBuilder sb, int start,int end){
        while (start<end){
            char temp=sb.charAt(start);
            sb.setCharAt(start,sb.charAt(end));
            sb.setCharAt(end,temp);
            start++;
            end--;
        }
    }
}