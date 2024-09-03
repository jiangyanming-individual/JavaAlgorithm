package DpQuestion;

import java.util.Scanner;

public class jumpFloorDemo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            jumpFloor(n);
        }
    }

    public  static int jumpFloor (int number) {
        // i下标为i的有多少种跳发
        int[] dp=new int[number+1];
        dp[1]=1;
        dp[2]=2;
        for (int i=3;i<=number;i++) {
            dp[i]=dp[i-1] + dp[i-2];
        }
        System.out.println("结果为："+ dp[number]);
        return dp[number];
    }
}
