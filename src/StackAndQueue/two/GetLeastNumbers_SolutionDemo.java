package StackAndQueue.two;

import javafx.scene.layout.Priority;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class GetLeastNumbers_SolutionDemo {

    /**
     * 直接排序
     * @param args
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n=scanner.nextInt();
        int[] nums=new int[n];

        for (int i=0;i<n;i++){
            nums[i]=scanner.nextInt();
        }

        int k=scanner.nextInt();
        ArrayList<Integer> list = GetLeastNumbers_Solution(nums, k);

        for (Integer i : list) {
            System.out.print(i);
            System.out.println(" ");
        }


    }
    //使用大根堆
    public static ArrayList<Integer> GetLeastNumbers_Solution (int[] input, int k) {

        //极端条件：
        if (input.length==0 || k==0) return new ArrayList<>();
        ArrayList<Integer> res=new ArrayList<>();
        //优先级队列，降序  (o1,o2)-> o1.compareTo(o2)是升序
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2)-> o2.compareTo(o1));

        // 先将钱k个元素放入到队列中；
        for (int i=0;i<k;i++){
            queue.add(input[i]);
        }
        // 和剩余的n -k个元素进行比较
        for (int i=k;i<input.length;i++) {

            //将队列中最大元素弹出，加入较小的元素
            if (queue.peek()>input[i]){
                queue.poll();
                queue.add(input[i]);
            }
        }

        //收集结果
        while (!queue.isEmpty()){
            res.add(queue.poll());
        }
        return res;
    }
}
