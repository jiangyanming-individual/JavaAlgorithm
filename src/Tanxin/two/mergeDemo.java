package Tanxin.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class mergeDemo {

    public int[][] merge(int[][] intervals) {

        List<List> result = new ArrayList<>();
        List path = new ArrayList();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[i - 1][1]) {
                intervals[i][0]=Math.min(intervals[i][0],intervals[i-1][0]);
                intervals[i][1] = Math.max(intervals[i][1], intervals[i - 1][1]);
                path.add(intervals[i][0]);
                path.add(intervals[i][1]);
            }
        }

    }
}
