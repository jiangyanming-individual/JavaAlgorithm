package LiKoHot100.滑动窗口;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findAnagramsDemo {


    /***
     *
     * 设置滑动窗口
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {

        int sLen = s.length();
        int pLen = p.length();

        List<Integer> res = new ArrayList<>();
        // 特殊情况，不符合要求
        if (sLen< pLen){
            return new ArrayList<Integer>();
        }

        int[] sCount = new int[26];
        int[] pCount= new int[26];

        // 统计词频
        for (int i = 0; i <pLen ; i++) {
            sCount[s.charAt(i)-'a']++;
            pCount[p.charAt(i) -'a'] ++;
        }

        // 判断起始位置是否符合要求
        if (Arrays.equals(sCount,pCount)){
            res.add(0);
        }

        // 以差距长度进行移动，第二个下标开始是否符合要求
        for (int i = 0; i <sLen - pLen ; i++) {
            //滑动pLen长度
            sCount[s.charAt(i) - 'a']--;
            sCount[s.charAt(i + pLen) - 'a'] ++;
            // 加入到结果集中
            if (Arrays.equals(sCount, pCount)){
                res.add(i + 1);
            }
        }
        return res;
    }
}
