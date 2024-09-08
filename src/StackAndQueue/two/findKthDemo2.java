package StackAndQueue.two;

import java.security.Key;
import java.util.PriorityQueue;
import java.util.Scanner;

public class findKthDemo2 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] nums=new int[n];

        for (int i=0;i<n;i++){
            nums[i]=scanner.nextInt();
        }

        int k=scanner.nextInt();
//        int res = findKth(nums,n,k);
//        System.out.println(res);


    }
    public  int findKth (int[] a, int n, int K) {
        return quirkSort(a,0,n-1,K);
    }

    /**
     * 快排
     * @return
     */
    public int quirkSort(int[] nums,int left, int right ,int k){
        int res= partition(nums,left,right);
        // 如果res =k-1相等了直接返回 nums[res];
        if (res == k -1){
            return nums[res];
        }else if (res> k-1){
            // 往左边找；递归找左边
            return quirkSort(nums,left,res-1,k);
        }else {
            // 递归找右边；res<k-1
            return quirkSort(nums,res+1,right, k);
        }
        // 没找到返回-1；
    }
    /**
     * 分治排序
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public int partition(int[] nums, int left, int right){
        int key=nums[left];
        while (left<right){
            //左大右小
            while (left<right && nums[right]<=key){
                right--;
            }
            //如果找到nums[right]>=keym,就移动到左边；
            nums[left]=nums[right];
            while (left<right && nums[left]>=key){
                left++;
            }
            // 如果找到nums[left]< key,往右边移动
            nums[right] =nums[left];
        }
        // 中间位置
        nums[left] =key;
        // 返回中间下标
        return  left;
    }


}
