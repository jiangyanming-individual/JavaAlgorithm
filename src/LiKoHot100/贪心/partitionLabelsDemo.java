package LiKoHot100.贪心;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class partitionLabelsDemo {


    /***
     * 划分字母区间
     * 1. 使用nums[26] 字母进行统计最远的index,
     * 2. start和 end ， 如果(i == end)  取结果: list.add((end - start) + 1), 上一个结果的终点位置end:
     * 更新：start=end +1;
     * 3. 返回结果list
     *
     * @param s
     * @return
     */
    public List<Integer> partitionLabels(String s){
        // 取结果
        List<Integer> res = new ArrayList<>();
        int[] table = new int[26];
        int start=0;
        int end =0;
        for (int i=0;i<s.length();i++){
            // 统计一下字母的最远下标：
            table[s.charAt(i) -'a'] = i;
        }
        for (int i=0;i<s.length();i++){
            //取到最远的下标index
            end= Math.max(end, table[s.charAt(i) -'a']);
            // 如果到达最远的下标了：取结果并且将start更新为end +1;
            if (i == end){
                res.add((end -start) +1);
                start= end +1;
            }
        }

        return res;
    }
}
