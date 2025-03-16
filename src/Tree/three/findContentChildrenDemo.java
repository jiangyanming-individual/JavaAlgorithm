package Tree.three;

import java.util.Arrays;
import java.util.Scanner;

public class findContentChildrenDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m= scanner.nextInt();
        int n= scanner.nextInt();

        int[] g=new int[m];
        int[] s=new int[n];

        for (int i=0;i<g.length;i++){
            g[i]=scanner.nextInt();
        }

        for (int j=0;j<s.length;j++){
            s[j]=scanner.nextInt();
        }
        int contentChildren = findContentChildren(g, s);
        System.out.println(contentChildren);
    }
    /**
     * 分化饼干
     * 1. 遍历胃口，然后将饼干大小作为一个可以移动的点
     * 2. 一定要判断 饼干的下标 index>=0, 不然会出现错误的情况
     * @param g
     * @param s
     * @return
     */
    public static int findContentChildren(int[] g, int[] s) {

        if (s.length == 0|| g.length == 0) return 0;
        int maxCount=0;
        // 降序
        Arrays.sort(g);
        Arrays.sort(s);
        int index=s.length-1;

        // 遍历胃口
        for (int i=g.length-1;i>=0 && index>=0;i--){
            if (s[index]>=g[i] && index>=0){
                maxCount++;
                index--;
            }
        }


        return maxCount;
    }
}
