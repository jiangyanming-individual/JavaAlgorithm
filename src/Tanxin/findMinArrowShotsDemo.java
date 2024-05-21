package Tanxin;

import java.util.Arrays;

public class findMinArrowShotsDemo {

    // 1.先按左边界进行升序排列
    //2. 如果point[i][0] > point[i-1][1] 第i个气球的左边界大于i-1个气球的右边界就需要一只箭
    public int findMinArrowShots(int[][] points){

        /**
         *  Integer.compare()比较大小，不然报内存溢出。x <y return -1, x == y return 0, x >y return 1;
         */
        Arrays.sort(points,(a,b)->{
            return Integer.compare(a[0],b[0]);
        });
        //一定需要一只箭，因为points不为空；
        int result=1;
        for (int i = 1; i < points.length; i++){
            if (points[i][0]> points[i-1][1]){
                result++ ;
            }else {
                //更新最小的右边界：
                points[i][1] =Math.min(points[i][1], points[i-1][1]);
            }
        }
        return result;
    }
}
