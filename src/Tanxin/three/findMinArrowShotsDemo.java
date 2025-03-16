package Tanxin.three;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class findMinArrowShotsDemo {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();

        int[][] nums=new int[n][2];

        for (int i=0;i<nums.length;i++){
            for (int j=0;j<2;j++){
                nums[i][j]=scanner.nextInt();
            }
        }
        findMinArrowShots(nums);
    }
    /**
     *
     * 1. 先排序，按照起始点进排列。 Integer.compare(o1[0],o2[0]) 防止大数。
     * 2. nums[i][0] > nums[i-1][1]，不重合， 直接count++；
     * 3. 反之更新最小的右边界。nums[i][1] =min(nums[i-1][1],nums[i][1])
     * 3. 进行统计操作
     *
     *
     * @param points
     * @return
     */
    public static int findMinArrowShots(int[][] points) {


        // 按照起始端点进行升序操作
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0],o2[0]);
            }
        });

        int count=1;
        for (int i=1;i<points.length;i++){

            //不重合：
            if (points[i][0]>points[i-1][1]){
                count++;
            }else {
                // 重合：更新最小的右边界：
                points[i][1]=Math.min(points[i][1],points[i-1][1]);
            }
        }
        System.out.println(count);
        return count;
    }
}
