package Tanxin.three;

import java.util.Scanner;

public class jumpDemo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] nums=new int[n];
        for (int i=0;i<nums.length;i++){
            nums[i]=scanner.nextInt();
        }
        int jump = jump(nums);
        System.out.println(jump);

    }
    /**
     * 跳跃游戏2：
     * 1. 当前的覆盖范围
     * 2. 获取到下一次的最大覆盖范围，
     * 3. 如果遍历到当前的覆盖范围后，更新当前的覆盖范围为下一次的覆盖范围。如果下一次的覆盖范围>= nums.length 就直接结束
     *
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {

        if (nums.length == 1) return 0;
        //设置覆盖范围
        int curCover=0;
        int nextCover=0;
        // 默认跳一次
        int count=0;
        for (int i=0;i<nums.length;i++){

            //在当前范围内，下一次最远能跳多远。
            nextCover=Math.max(nextCover, i+nums[i]);
            if (i== curCover){
                count++;
                curCover=nextCover;
                if (curCover>= nums.length-1){
                    break;
                }
            }
        }
        return count;
    }

}
