package Tanxin;

import java.util.ArrayList;
import java.util.List;

public class partitionLabelsDemo {

    /**
     * 使用模拟的方法
     * @param S
     * @return
     */
    public List<Integer> partitionLabels(String S) {

        List<Integer> result = new ArrayList<>();
        int[] hash= new int[26];
        for (int i = 0; i < S.length(); i++) {
            hash[S.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int end=0;
        for (int i=0;i<S.length();i++) {

            //找到最大的右边界：
            end = Math.max(end,hash[S.charAt(i) - 'a']);

            if (i == end){
                result.add((end - start) + 1); //加入一段字符串的长度
                start= end + 1; //更新起始位置
            }

        }
        return result;
    }
}
