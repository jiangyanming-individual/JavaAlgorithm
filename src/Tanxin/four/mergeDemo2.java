package Tanxin.four;

import java.util.*;

public class mergeDemo2 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n =scanner.nextInt();

        int [][] nums=new int[n][2];
        for (int i=0;i<n;i++){
            for (int j=0;j<2;j++){
                nums[i][j]=scanner.nextInt();
            }
        }
        int[][] merge = merge(nums);

        for (int[] ints : merge) {
            System.out.println(ints);
        }
    }
    /**
     * 合并区间
     * 1. 先按照区间的起点进行升序操作
     * 2. start=nums[0][0], end=start[0][1]
     * 3. 如果 nums[i][0] > end， 就将（start,end）加入到结果集中，然后更新start 和 end
     * 4. 如果 nums[i][0] < end , 即有重叠的区间：end =max(end, nums[i][1]);
     * 5. 将列表转为二维数组：
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] -o2[0];
            }
        });
        List<int[]> result=new ArrayList<>();
        int start=intervals[0][0];
        int end=intervals[0][1];

        for (int i=1;i<intervals.length;i++){

            if (intervals[i][0]>end){
                result.add(new int[]{start,end});
                start=intervals[i][0];
                end=intervals[i][1];
            }else {
                // 更新最大的右边界：
                end=Math.max(end,intervals[i][1]);
            }
        }
        // 加上最后的一组：
        result.add(new int[]{start,end});
        // 将list转为二维数组
        return result.toArray(new int[result.size()][]);
    }



}
