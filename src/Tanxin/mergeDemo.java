package Tanxin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class mergeDemo {

    /**
     * 合并区间
     * @param intervals
     * @return
     */
    public int[][] merge(int [][] intervals){

        List<int[]> result = new ArrayList<>();
        //先排序
        Arrays.sort(intervals,(a,b)->{
            return a[0]-b[0];
        });
        //把第一个加入：
        result.add(new int[]{intervals[0][0],intervals[0][1]});
        for (int i = 1; i < intervals.length; i++){
            int end= result.get(result.size()-1)[1]; //上一个区间的右边界
            int start= result.get(result.size()-1)[0]; //上一个区间的左边界
            if (intervals[i][0]<= end){
                end = Math.max(intervals[i][1], end);
                result.remove(result.size()-1); //移除重叠的第一部分；
                result.add(new int[]{start,end}); //加入更新后重叠的部分：
            }else {
                //如果不重叠直接加入新的部分
                result.add(intervals[i]);
            }
        }
        //返回结果：
        return result.toArray(new int[result.size()][]);
    }
}
