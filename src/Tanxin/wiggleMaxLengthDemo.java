package Tanxin;

public class wiggleMaxLengthDemo {


    public int wiggleMaxLength(int[] nums) {

        int preDiff=0;
        int curDiff=0;

        int result=1; //默认有一个峰值
        for (int i=0;i<nums.length-1;i++){
            curDiff =nums[i+1] - nums[i] ;//记录当前的差值

            // preDiff是存在为0 的情况
            if ((preDiff>=0 && curDiff<0) || (preDiff<=0 && curDiff> 0)){
                result++;
                //更新preDiff
                preDiff= curDiff;
            }
        }
        return result;
    }
}
