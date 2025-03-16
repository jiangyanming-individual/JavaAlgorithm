package demo;

import java.util.Map;
import java.util.Scanner;

public class Main3 {
    static int maxValue =Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(",");


    }

    public  static int traversal(TreeNode root){
        if (root == null){
            return 0;
        }
        // 只取正的
        int left = Math.max(traversal(root.left),0);
        int right =Math.max(traversal(root.right),0);

        int currentValue= root.val + left + right;
        maxValue = Math.max(currentValue, maxValue);
        // 返回当前最大
        return root.val + Math.max(left, right);
    }
}
