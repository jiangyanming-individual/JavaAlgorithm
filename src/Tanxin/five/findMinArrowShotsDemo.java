package Tanxin.five;

import java.util.Arrays;
import java.util.Comparator;

public class findMinArrowShotsDemo {

    /**
     * 用最少的数量的箭引爆气球：
     * 1. 先按照左边界进行排序操作
     * 2. 如果没有重叠，直接加1
     * 3. 有重叠的话，直接更新最小的右边界
     * @param points
     * @return
     */
    public int findMinArrowShots(int [][] points){

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0],o2[0]);
            }
        });
        // 统计箭数
        int count=1;

        for (int i=1;i<points.length;i++){
            // 如果不重叠，就需要进行加1的操作：
            if (points[i][0]>points[i-1][1]){
                count++;
            }else {
                // 重叠，更新最小的右边界；
                points[i][1]=Math.min(points[i][1],points[i-1][1]);
            }
        }
        return count;
    }
}
