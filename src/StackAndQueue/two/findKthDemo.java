package StackAndQueue.two;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class findKthDemo {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] nums=new int[n];

        for (int i=0;i<n;i++){
            nums[i]=scanner.nextInt();
        }

        int k=scanner.nextInt();
        int res = findKth(nums,n,k);
        System.out.println(res);


    }
    public static int findKth (int[] a, int n, int K) {
        // 默认升序，小跟队
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i=0;i<K;i++) {
            queue.add(a[i]);
        }
        for (int i=K;i<n;i++){
            //比队首大的元素入队
            if (queue.peek()<a[i]){
                queue.poll();
                queue.add(a[i]);
            }
        }

        //直接得到第一个元素就是第K大的元素
        return queue.isEmpty() ? 0: queue.peek();
    }
}
