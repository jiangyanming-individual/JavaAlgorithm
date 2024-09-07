package xiaomi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main2 {

    public static void main(String args[]){
            int n,m;
            Scanner scanner = new Scanner(System.in);
            n=scanner.nextInt();
            m=scanner.nextInt();
//            System.out.println(m);

            int[] numsA=new int[n];
            int[] numsB=new int[n];

            for (int i=0;i<n;i++){
                numsA[i]=scanner.nextInt();
            }
            for (int i=0;i<n;i++){
                numsB[i]=scanner.nextInt();
            }

        int result = getResult(numsA, numsB,m);
        System.out.println(result);
        scanner.close();
    }


    public static int getResult(int[] numsA,int[] numsB,int m){

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numsB.length; i++) {
            map.put(numsB[i],i+1);
        }
        Arrays.sort(numsB);
        int sum=0;
        int index=-1;
        for (int i=0;i<numsA.length;i++){
            sum += numsA[i] * numsB[i];
            if (sum>=m){
                //记录翻倍书
                index=i+1;
                return index;
            }
        }
        // 返回天
        return -1;
    }



}

