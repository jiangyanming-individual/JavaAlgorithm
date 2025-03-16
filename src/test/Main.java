package test;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        scanner.close();
        boolean res = isPalindrome(string);
        System.out.println("isPalindrome(" + string+ ") ->"+ res);
    }
    public static boolean isPalindrome(String s){

        int left =0;
        int right=s.length()-1;
        while (left < right) {
            while (left < right &&!Character.isLetter(s.charAt(left))) {
                left++;
            }
            while (left < right &&!Character.isLetter(s.charAt(right))) {
                right--;
            }
            char leftChar = Character.toLowerCase(s.charAt(left));
            char rightChar = Character.toLowerCase(s.charAt(right));
            // 不相等直接报错
            if (leftChar!= rightChar) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

