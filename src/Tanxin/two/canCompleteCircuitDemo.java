package Tanxin.two;

public class canCompleteCircuitDemo {


    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalSum = 0;
        int curSum = 0;
        int start = 0; //起始位置
        for (int i = 0; i < gas.length; i++) {
            totalSum += gas[i] - cost[i];
            curSum += gas[i] - cost[i];
            if (curSum < 0) {
                //从头开始计数
                start = i + 1;
                curSum = 0;
            }
        }
        //总的计数小于0，一定不能环绕一圈
        if (totalSum < 0) {
            return -1;
        }
        return start;
    }
}
