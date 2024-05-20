package Tanxin;

public class canCompleteCircuitDemo {

    /**
     *加油站：
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {

        // 1. 如果总的剩余油量都小于0，那一定义不能环绕一周
        // 2. 如果[0,i]区间内，剩余油量累计< 0 那肯定也不能环绕一周，中间会断油。
        int totalSum= 0;
        int curSum=0;
        int index=0; //默认index从0开始；
        for (int i = 0; i < gas.length; i++) {

            curSum+= gas[i] - cost[i];
            totalSum+= gas[i] - cost[i];
            //第二种情况
            if (curSum < 0){
                index= i+1;
                curSum=0; //curSum重新计数
            }
        }
        //第一种情况，一定环绕不了
        if (totalSum < 0) return  -1;
        return index;
    }
}
