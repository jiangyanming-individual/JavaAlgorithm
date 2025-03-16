package Tanxin.four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class mergeDemo {

    /**
     * 合并区间
     *
     * 1. 按照最左边的节点进行升序排列， start=nums[0][0], end=nums[0][1] (start,end表示当前最大的区间);
     * 2. 如果nums[i][0]> end， 直接result加入结果，然后更新 start 和end 区间。
     * 3. 如果nums[i][0]<end ， 更新最大右边界，的nums[i][1]= max(nums[i][1],end)。
     *
     * @param intervals
     * @return
     */

    public int[][] merge(int[][] intervals) {


        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> result=new ArrayList<>();
        int start= intervals[0][0];
        int end= intervals[0][1];

        for (int i = 1; i <intervals.length ; i++) {
            // 取结果
            if (intervals[i][0]> end){
                result.add(new int[]{start,end});
                // 更新左右了边界；
                start=intervals[i][0];
                end=intervals[i][1];
            }else {
                // intervals[i][0]< end;
                // 更新最大右边界：
                end=Math.max(end,intervals[i][1]);
            }
        }
        // 取最后面的结果：
        result.add(new int[]{start,end});
        // 返回结果
        return  result.toArray(new int[result.size()][]);

    }
}
