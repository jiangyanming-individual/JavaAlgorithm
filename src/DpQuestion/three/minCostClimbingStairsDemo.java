package DpQuestion.three;

import java.util.Scanner;

public class minCostClimbingStairsDemo {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){

            String line= scanner.nextLine();
            // 转为字符数组：
            String[] strArray = line.split(",");
            int[] intArray = new int[strArray.length];
            for (int i = 0; i < strArray.length; i++) {
                intArray[i] = Integer.parseInt(strArray[i]);
            }
            minCostClimbingStairs(intArray);
        }
    }

    public  static int minCostClimbingStairs (int[] cost) {
        // write code here
        //花费最少费用为：dp[i]
        int[] dp=new int[cost.length+1];
        dp[0]=0;
        dp[1]=0;
        for (int i=2;i<=cost.length;i++) {
            dp[i]=Math.min(dp[i-1] + cost[i-1],dp[i-2]+ cost[i-2]);
        }
        System.out.println(dp[cost.length]);
        return dp[cost.length];
    }
}
