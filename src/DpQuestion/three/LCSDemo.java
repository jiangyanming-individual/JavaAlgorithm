package DpQuestion.three;

import java.util.Scanner;
import java.util.Stack;

public class LCSDemo {

    /**
     * 两个字符串的最长公共子序列， 可以是不连续的：
     * @param args
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()){
            String input = scanner.nextLine();
            String[] parts = input.split(",");
            String str1 = parts[0];
            String str2 = parts[1];
            LCS(str1,str2);
        }
        scanner.close();
    }


    public static String LCS (String s1, String s2) {
        if ((s1.isEmpty() && !s2.isEmpty()) || (!s1.isEmpty() && s2.isEmpty()))
            return "-1";
        //定义dp
        int[][] dp=new int[s1.length() +1][s2.length()+1];
        //初始化化： dp[1][0], dp[0][j]=0;
        String res="";
        for (int i=1;i<=s1.length();i++) {
            for (int j=1;j<=s2.length();j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                 }
            }
        }
        //使用栈来存数据,倒序，先进后出：
        Stack<Character> stack = new Stack<>();

        int i=s1.length();
        int j=s2.length();
        while (dp[i][j]!=0){
            if (dp[i][j] == dp[i-1][j]){
                i--;
            }
            else if (dp[i][j] == dp[i][j-1]){
                j--;
            }
            else if (dp[i][j]> dp[i-1][j-1]){
                i--;
                j--;
                //加入结果：
                stack.push(s1.charAt(i));
            }
        }
        while (!stack.isEmpty()){
            //拼接
            res+=stack.peek();
            //删除节点
            stack.pop();

        }
        System.out.println(res.isEmpty() ? "-1" : res);
        return res.isEmpty() ? "-1" : res;
    }
}
