package xiaomi;

import java.util.*;
public class Main {

    public static void main(String args[]){
            int n;
            Scanner sc = new Scanner(System.in);
            n=sc.nextInt();
            int[] A=new int[n];
            int[] B=new int[n];
            while (sc.hasNext()){
                for (int i =0;i<A.length;i++){
                    A[i]=sc.nextInt();
                    System.out.println(A[i]);
                }
                for (int i =0;i<B.length;i++){
                    B[i]=sc.nextInt();
                    System.out.println(B[i]);
                }
                int minTime = getMinTime(A, B);
                System.out.println(minTime);
            }
            sc.close();
    }

    public static int getMinTime(int[] nums1,int[] nums2){
        int res=0;
        int min1=Integer.MAX_VALUE;
        int index1=0;
        for (int i=0;i<nums1.length;i++){
            //找出最小的
            if (nums1[i]<min1){
                min1=nums1[i];
                index1=i;
            }
        }
        // B
        int min2=Integer.MAX_VALUE;
        int index2=0;
        for (int i=0;i<nums2.length;i++){
            //找出最小的
            if (nums2[i]<min2){
                min2=nums2[i];
                index2=i;
            }
        }
        if (index1 !=index2){
            res=Math.max(min1,min2);
        } else {
            res= min1+ min2;
        }
        System.out.println("结果：" + res);
        return res;
    }

}

