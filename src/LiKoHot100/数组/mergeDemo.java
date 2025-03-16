package LiKoHot100.数组;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class mergeDemo {
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
    public int[][] merge(int[][] intervals) {

        //升序排序：
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]- o2[0];
            }
        });

        List<int[]> res = new LinkedList<>();
        int start= intervals[0][0];
        int end =intervals[0][1];

        for (int i=1;i< intervals.length;i++){
            if (intervals[i][0]> end){
                res.add(new int[]{start,end});
                // 更新start 和end
                start= intervals[i][0];
                end= intervals[i][1];
            }else {
                //有重合：
                end= Math.max(intervals[i][1], end);
            }
        }
        // 将最后一组加入
        res.add(new int[]{start,end});
        // 转为二维数组.语法糖
        return res.stream().toArray(int[][]::new);

    }
}
