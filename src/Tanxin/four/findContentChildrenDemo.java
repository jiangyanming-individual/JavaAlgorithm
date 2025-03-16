package Tanxin.four;

import java.util.Arrays;

public class findContentChildrenDemo {


    public int findContentChildren(int[] g, int[] s) {
        if (g.length == 0 || s.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int index=s.length-1;
        int result=0;
        for (int i=g.length-1;i>=0 && index>=0;i--){
            if (s[index]>=g[i]){
                result++;
                // 饼干索引往后减
                index--;
            }
        }
        return result;
    }
}
