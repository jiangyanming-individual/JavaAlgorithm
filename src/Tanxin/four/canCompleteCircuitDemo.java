package Tanxin.four;

import java.util.Arrays;

public class canCompleteCircuitDemo {

    /**
     * 加油站：
     *
     * 1. 求每个站点的剩余油量： gas[i] -cost[i]
     * 2. 使用一个计数总和，如果总和小于0， 就需要从下一个站点进行计数
     * 3. 使用index 进行返回
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {


        int index=0;
        int totalSum=0;
        int curSum=0;
        for (int i=0;i<gas.length;i++){
            curSum+=gas[i]-cost[i];
            totalSum+=gas[i]-cost[i];

            if (curSum<0){
                curSum=0;
                index=i+1;
            }
        }
        // 如果总的sum小于0，肯定不行
        if (totalSum<0){
            return -1;
        }
        return index;
    }
}
