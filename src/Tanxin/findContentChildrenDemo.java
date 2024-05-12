package Tanxin;

import java.util.Arrays;

public class findContentChildrenDemo {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count=0;
        int index=s.length-1;
        //满足大饼干喂饱大胃口
        for (int i=g.length-1;i>=0;i--){
            if (index >=0 && s[index]>=g[i]){
                index--;
                count++;
            }
        }
        return count;
    }

}
