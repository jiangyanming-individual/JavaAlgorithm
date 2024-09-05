package Array;

import java.util.Scanner;

public class generateMatrixDemo {


    /**
     * 模拟：
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n= scanner.nextInt();
        generateMatrix(n);

    }

    //todo  奇数需要单独处理：
    public static int[][] generateMatrix(int n) {

        int[][] res=new int[n][n];
        int loop= n/2;
        int mid= n/2; // 中间index；
        int count=1;
        int offset=1;

        int startx=0,starty=0;
        int right=n-1;
        int i,j;

        while (loop>0){

            for (j=starty;j<n-offset;j++){
                res[startx][j]=count++;
            }

            for (i=startx;i<n-offset;i++) {
                res[i][j]=count++;
            }
            // j 不变的：
            for (;j>starty;j--){
                res[i][j] =count++;
            }

            for (;i>startx;i--){
                res[i][j]=count++;
            }
            startx++;
            starty++;
            offset++;
            loop--;
        }

        if (n % 2!=0){
            res[mid][mid]=count;
        }
        for (int[] re : res) {
            System.out.println(re);
        }
        return res;
    }

}
