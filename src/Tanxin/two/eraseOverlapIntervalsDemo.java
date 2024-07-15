package Tanxin.two;

import java.util.Arrays;
import java.util.Comparator;

public class eraseOverlapIntervalsDemo {


    public int eraseOverlapIntervals(int[][] intervals) {
        //先排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i-1][1]) {
                //取最小的右边界；
                intervals[i][1] = Math.min(intervals[i][1], intervals[i - 1][1]);
                continue;
            } else {
                //统计不需要更新的区间：
                count++;
            }
        }
        return intervals.length - count;
    }
}
