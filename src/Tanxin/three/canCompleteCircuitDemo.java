package Tanxin.three;

import java.util.Scanner;

public class canCompleteCircuitDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int [] g=new int[n];
        int [] cost=new int[n];
        for (int i=0;i<g.length;i++){
            g[i]=scanner.nextInt();
        }
        for (int j=0;j<cost.length;j++){
            cost[j]=scanner.nextInt();
        }
        canCompleteCircuit(g,cost);
    }
    /**
     * 加油站问题：
     * 1. 使用一个curSum 去累加每个站点的净胜油量 （g[i] -cost[i]），
     * 和totalSum也是统计净胜油量 ，如果totalSum<0 那肯定是到不了
     * 2. 如果当前的净胜油量已经小于0了， 那就从下一个站点从新开始统计。
     * 3. 返回下标
     *
     * @param gas
     * @param cost
     * @return
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {

        int totalSum=0;
        int curSum=0;
        int index=0;
        for (int i=0;i<gas.length;i++) {
            totalSum+=gas[i]-cost[i];
            //到达这个站点净胜油量
            curSum += gas[i] - cost[i];
            if (curSum < 0) {
                curSum = 0;
                index = i + 1;
            }
        }
        // 净胜油量都小0， 肯定不能转一圈：
        if (totalSum<0){
            return -1;
        }
        System.out.println(index);
        return index;
    }
}
