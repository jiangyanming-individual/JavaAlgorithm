package Tanxin;

import java.util.Arrays;
import java.util.Comparator;

public class eraseOverlapIntervalsDemo {
    /**
     * 无重叠区间：
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        //自定义比较器：
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        //需要移除区间的个数：
        int result = 0;
        int start = intervals[0][1]; //切割点
        for (int i = 1; i < intervals.length; i++) {
            //不重叠
            if (intervals[i][0] >= start) { //要大于等于切割点；
                start=intervals[i][1];//然后将更新切割点，扩大范围
            }else {
                //重叠；比较换取最小的右边界
                start=Math.min(intervals[i][1],start);
                result++;
            }
        }
        return result;
    }
}
