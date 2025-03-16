package Tanxin.four;

import java.util.Arrays;
import java.util.Comparator;

public class eraseOverlapIntervalsDemo {


    /**
     * 无重叠区间：
     * 1. 如果intervals[i][0]<intervals[i-1][1] ， 有重合时，进行统计和更新最右的边界
     * 2. 返回count
     * @param intervals
     * @return
     */
    public static int eraseOverlapIntervals(int[][] intervals) {

        // 升序按照起点排列
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] -o2[0];
            }
        });
        int count =0;
        for (int i=1;i<intervals.length;i++){

            if (intervals[i][0]<intervals[i-1][1]){
                //更新i 的最右边界：
                intervals[i][1]=Math.min(intervals[i][1],intervals[i-1][1]);
                count++;
            }
        }
        return count;
    }
}
