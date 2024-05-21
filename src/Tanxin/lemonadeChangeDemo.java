package Tanxin;

public class lemonadeChangeDemo {
    /**
     * 柠檬水找零的问题：
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {

        int fiveCount=0;
        int tenCount=0;

        for (int bill : bills) {
            if (bill == 5) {
                fiveCount++;
            }else if (bill == 10){
                if (fiveCount <=0){
                    return false;
                }
                fiveCount --;
                tenCount++;
            }else {
                //优先使用10 和 5的去找零 20
                if (tenCount >0 && fiveCount>0){
                    fiveCount -- ;
                    tenCount --;
                }else if (fiveCount>=3){
                    fiveCount -=3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
