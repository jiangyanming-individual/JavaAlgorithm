package Tanxin.four;

import java.util.Scanner;

public class monotoneIncreasingDigitsDemo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = monotoneIncreasingDigits(n);
        System.out.println(i);
    }

    /**
     * 单调递增的数字
     * 1. 从后往前遍历
     * 2. 使用index进行标记需要变为9的index，
     * 3. 从index往后进行遍历，将元素全部变为9；
     * @param n
     * @return
     */
    public static int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        char[] charArray = s.toCharArray();

        // 使用一个标志位进行标识：
        int index=s.length();
        // 从后往前遍历
        for (int i=charArray.length-2;i>=0;i--){

            //如果前一个元素大于后一个元素，则当前元素减一
            if (charArray[i]>charArray[i+1]){
                charArray[i]--;
                index= i+1;
            }
        }

        for (int i=index;i<s.length();i++){
            charArray[i]='9';
        }

        // 转为整数：
        return Integer.parseInt(String.valueOf(charArray));
    }

}
