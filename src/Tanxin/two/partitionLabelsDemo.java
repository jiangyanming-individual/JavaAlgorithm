package Tanxin.two;

import java.util.ArrayList;
import java.util.List;

public class partitionLabelsDemo {

    public List<Integer> partitionLabels(String s) {
        List result = new ArrayList();

        int[] set = new int[26];
        //记录字母最远的index
        for (int i = 0; i < s.length(); i++) {
            set[s.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, set[s.charAt(i) - 'a']);
            //找到最远下标，更新start;
            if (i == end) {
                result.add((end - start) + 1);
                start = end + 1;
            }
        }
        return result;
    }
}
