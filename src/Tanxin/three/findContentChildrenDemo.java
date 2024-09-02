package Tanxin.three;

import java.util.Arrays;

public class findContentChildrenDemo {

    /**
     * 分发饼干的问题：
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s){

        int maxCount=0;
        // 从小到大排
        Arrays.sort(g);
        Arrays.sort(s);
        int index=s.length-1;
        for (int i=g.length-1;i>=0;i--){
            if (index>=0 && s[index] >= g[i]){
                maxCount++;
                index--;
            }
        }
        return maxCount;
    }
}
