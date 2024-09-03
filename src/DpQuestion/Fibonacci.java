package DpQuestion;

import java.util.Scanner;

public class Fibonacci {


    public static void main(String[] args) {
        // 输入n:
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();

        Fibonacci(n);
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param n int整型
     * @return int整型
     */
    public static int Fibonacci (int n) {
        // write code here
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;

        for (int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        System.out.println("结果为："+dp[n]);
        return dp[n];
    }
}
