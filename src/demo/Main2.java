package demo;

import java.util.Scanner;

public class Mian2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (scanner.hasNextInt()) { // 注意 while 处理多个 case
            int height = scanner.nextInt();
            int number= scanner.nextInt();
            getMin(height,number);
        }

    }

    public static int getMin(int height, int number){
        int count =0;
        if (number == 0){
            return height -1;
        }
        for (int i=1;i<=height;i++){
            
        }
        return count;
    }
}
