package Tanxin.four;

import java.util.Arrays;
import java.util.Comparator;

public class findMinArrowShotsDemo {


    /**
     *
     * 1. 使用头结点进行排序
     * 2. 如果nums[i][0]>nums[i-1][1], count++
     * 3. 否则nums[i][1]= min(nums[i][1],nums[i-1][1]) // 取重合的两个最小右边界。
     * 4. 返回count
     * @param points
     * @return
     */
    public  int findMinArrowShots(int[][] points) {

        // 进行降序排列：
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0],o2[0]);
            }
        });


        //最少使用一只箭
        int count=1;
        for (int i=1;i<points.length;i++){
            if (points[i][0]>points[i-1][1]){
                count++;
            }else {
                points[i][1]=Math.min(points[i][1],points[i-1][1]);
            }
        }
        return count;
    }

}
