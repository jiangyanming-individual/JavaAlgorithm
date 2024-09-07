package Array;

import java.util.Scanner;

public class compareDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s1 = scanner.nextLine();

        String[] split = s1.split(",");
        int compare = compare(split[0], split[1]);
        System.out.println(compare);
    }

    public static int compare (String version1, String version2) {

        // 双指针：
        int index1=0;
        int index2=0;

        char[] charArray1 = version1.toCharArray();
        char[] charArray2 = version2.toCharArray();
        int n1=charArray1.length;
        int n2=charArray2.length;

        // 直到某一个字符串结束
        while (index1< n1 || index2<n2){
            int num1=0;
            int num2=0;

            // 截取到下一个 .
            while (index1<n1 && charArray1[index1] !='.'){
                // 字符转为数字： 011 = 11
                num1= num1 * 10 + (charArray1[index1] - '0');
                index1++;
            }

            while (index2<n2 && charArray2[index2] !='.'){
                // 字符转为数字： 011 = 11
                num2= num2 * 10 + (charArray2[index2] - '0');
                index2++;
            }
            //当前是在.这个地方
            if (num1> num2) return 1;
            else if (num1<num2) return -1;

            //跳过 .
            index1++;
            index2++;
        }
        // 版本相同
        return 0;
    }
}
