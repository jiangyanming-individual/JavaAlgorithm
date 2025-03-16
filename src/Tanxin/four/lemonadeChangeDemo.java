package Tanxin.four;

public class lemonadeChangeDemo {


    /**
     * 柠檬水找零：
     * 1.
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {

        int fiveCount=0;
        int tenCount=0;

        for (int i=0;i< bills.length;i++) {

            if (bills[i] == 5){
                fiveCount++;
                //要有五元去找零
            }else if (bills[i] == 10 && fiveCount>0){
                tenCount ++;
                fiveCount--;
            }else {
                if (fiveCount>0 && tenCount>0){
                    fiveCount--;
                    tenCount--;
                }else if (fiveCount>=3){
                    fiveCount-=3;
                }else {
                    // 其他条件就不合法
                    return false;
                }
            }
        }
        return true;
    }
}
