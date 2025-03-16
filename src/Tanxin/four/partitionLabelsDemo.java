package Tanxin.four;

import java.util.ArrayList;
import java.util.List;

public class partitionLabelsDemo {


    /***
     * 划分字母区间
     * 1. 使用nums[26] 字母进行统计最远的index,
     * 2. start和 end ， 如果(i == end)  取结果: list.add((end - start) + 1), 上一个结果的终点位置end: 更新：start=end +1;
     * 3. 返回结果list
     *
     * @param s
     * @return
     */
    public static List<Integer> partitionLabels(String s) {

        // 取结果：
        List<Integer> list=new ArrayList<>();
        int [] nums=new int[26];
        // 记录最远的下标：
        for (int i=0;i<s.length();i++){
            nums[s.charAt(i) -'a']=i;
        }
        int start=0;
        int end=0;
        for (int i=0;i< s.length();i++){
            // 更新最远的index
            end=Math.max(end, nums[s.charAt(i) -'a']);
            if (i == end){
                // 取结果：
                list.add((end -start)+1);
                // 更新start
                start=end + 1;
            }
        }
        // 返回结果：
        return list;
    }
}
