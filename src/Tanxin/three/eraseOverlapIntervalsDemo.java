package Tanxin.three;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class eraseOverlapIntervalsDemo {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();

        int[][] nums=new int[n][2];
        for (int i=0;i<n;i++){

            for (int j=0;j<2;j++){
                nums[i][j]=scanner.nextInt();
            }
        }
        int i = eraseOverlapIntervals(nums);
    }
    /**
     * 无重叠区间：
     * 1. 按照左边界进行元素的升序排序，
     * 2. nums[i][0]<nums[i-1][1], 有重叠的情况，total++;
     * 3. 返回 total
     *
     * @param intervals
     * @return
     */

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                // 起点进行升序排序；
                return Integer.compare(o1[0],o2[0]);
            }
        });

        int total=0;
        for (int i=1;i<intervals.length;i++){
            // 有重叠的情况：
            if (intervals[i][0]<intervals[i-1][1]){
                // 更新元素i 的最小右区间
                intervals[i][1]=Math.min(intervals[i][1],intervals[i-1][1]);
                total++;
            }
        }
        // 最少的剩余区间：
        System.out.println(total);
        return total;
    }
}
