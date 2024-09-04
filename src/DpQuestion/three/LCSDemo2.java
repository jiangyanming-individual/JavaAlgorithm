package DpQuestion.three;

import java.util.Scanner;
import java.util.Stack;

public class LCSDemo2 {


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
    /***
     * 公共子序列：
     * @param str1
     * @param str2
     * @return
     */
    public static String LCS (String str1, String str2) {

        int[][] dp=new int[str1.length()+1][str2.length() +1];
        int maxLen=0;
        int maxLastIndex=0;
        for (int i=1;i<=str1.length();i++){
            for (int j=1;j<=str2.length();j++){
                if (str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1] + 1;
                    if (dp[i][j] >maxLen){
                        maxLen=dp[i][j];
                        maxLastIndex=i; //多跳了1;
                    }
                }else {
                    dp[i][j]=0;
                }
            }
        }
        System.out.println(str1.substring(maxLastIndex - maxLen, maxLastIndex));
        return str1.substring(maxLastIndex - maxLen, maxLastIndex); // (a,b)
    }

}
