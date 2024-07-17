package Tanxin.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class mergeDemo {

    public int[][] merge(int[][] intervals) {

        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                result.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                //更新最新最右的边界
                end = Math.max(end, intervals[i][1]);
            }
        }
        //加上最后的结果：
        result.add(new int[]{start, end});
        return result.toArray(new int[result.size()][]);
    }
}
