package demo;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (scanner.hasNextInt()) { // 注意 while 处理多个 case
            int height = scanner.nextInt();
            int number= scanner.nextInt();
            int min = getMin(height, number);
            System.out.println(min);
        }

    }

    public static int getMin(int height, int number){
        if (number == 0){
            return height -1;
        }
        int[] dp = new int[height + 1];
        dp[0]=0;
        dp[1]=0;
        // dp[i] = min(dp[i-1] + 1, dp[i - i /2] +1);
        for (int i=2;i<=height;i++){
            dp[i] = Math.min(dp[i-1] +1, dp[i - i /2] +1);
        }
        return dp[height];
    }
}
