package StringTest;

import java.util.Arrays;
import java.util.Scanner;

public class reverseStringRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = Integer.parseInt(scanner.nextLine());
        String intputString = scanner.nextLine();
        char[] chars = intputString.toCharArray();
        //反转全部
        reverseString(chars,0,chars.length-1);
        //反转0-k-1
        reverseString(chars,0,k-1);
        //反转k--length -1
        reverseString(chars,k,chars.length-1);
        // String s = chars.toString(); //打印的都是地址；
        System.out.println(chars);
    }
    public static void reverseString(char[] s,int start,int end){

        while (start<end) {
            char temp = s[start];
            s[start]=s[end];
            s[end]=temp;
            start++;
            end--;
        }
    }
}
