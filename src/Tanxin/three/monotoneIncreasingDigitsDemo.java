package Tanxin.three;

import java.util.Scanner;

public class monotoneIncreasingDigitsDemo {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int i = monotoneIncreasingDigits(n);
        System.out.println(i);
    }
    /**
     * 单调递增的数字
     * 1. 从后往前进行遍历，如果当前的nums[i]>nums[i+1], 当前元素减一，然后标记flag=i +1;
     * 2. 最后将字符数组转为int:
     * @param n
     * @return
     */
    public static int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        char[] charArray = s.toCharArray();

        // 默认是最后一个
        int flag=s.length();
        for (int i=charArray.length-2; i>=0;i--){
            if (charArray[i]>charArray[i+1]){
                // 当前字符进行减一；
                charArray[i]--;
                // flag进行标记
                flag=i+1;
            }
        }
        // 将从标记的index后面进行更新为9；
        for (int i=flag;i<s.length();i++){
            charArray[i]='9';
        }
        //转为int
        return Integer.parseInt(String.valueOf(charArray));
    }
}
