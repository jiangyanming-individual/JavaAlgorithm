package Tanxin.two;

import java.util.Arrays;
import java.util.Map;

public class findMinArrowShotsDemo {

    /**
     * 先排序：
     *
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            return Integer.compare(a[0],b[0]);
        });
        int count = 1;
        //最大右边界：
//        for (int i = 1; i < points.length; i++) {
//
//            if (points[i][0] > points[i-1][1]) {
//                count++;
//            } else {
//                //更新最小的右边界：
//                points[i][1]=Math.min(points[i-1][1],points[i][1]);
//            }
//        }
        int minRight=points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > minRight) {
                count++;
            } else {
                //更新最小的右边界：
                minRight=Math.min(minRight,points[i][1]);
            }
        }

        return count;
    }
}
