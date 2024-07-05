package Tanxin.two;

import java.util.Arrays;

public class findContentChildrenDemo {

    /**
     * 分发饼干
     *
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        //大饼干喂饱大胃口
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        //饼干数组下标：
        int index = s.length - 1;
        for (int i = g.length - 1; i >= 0; i--) {
            if (index >= 0 && s[index] >= g[i]) {
                count++;
                index--;
            }
        }
        return count;
    }
}
