package Tanxin.five;

import java.util.Arrays;
import java.util.Comparator;

public class eraseOverlapIntervalsDemo {


    public static void main(String[] args) {


    }
    /**
     * 无重叠区间：
     * 1. 按照左边界进行排序
     * 2. 如果nums[i][0]< nums[i-1][0]， 更新最小的右边界（nums[i][1],nums[i-1][1]）
     * 3. 反之进行跳过：
     * @param intervals
     * @return
     */
    public static int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int count=0;
        for (int i=1;i<intervals.length;i++){
            // 更新最小的右边界：
            if (intervals[i][0]<intervals[i-1][1]){
                intervals[i][1]=Math.min(intervals[i][1],intervals[i-1][1]);
                count++;
            }
        }
        return count;
    }
}
