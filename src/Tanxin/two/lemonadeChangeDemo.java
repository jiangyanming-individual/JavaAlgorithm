package Tanxin.two;

public class lemonadeChangeDemo {

    public boolean lemonadeChange(int[] bills) {

        int fiveCount = 0;
        int tenCount = 0;
        int twentyCount = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                fiveCount++;
            } else if (bills[i] == 10) {
                if (fiveCount <= 0) {
                    return false;
                }
                fiveCount--;
                tenCount++;
            } else {
                //优先使用10和5
                if (fiveCount > 0 && tenCount > 0) {
                    //使用一张5,一张10
                    fiveCount--;
                    tenCount--;
                } else if (fiveCount >= 3) {
                    fiveCount -= 3;
                } else {
                    //其他条件不满足
                    return false;
                }
            }
        }
        return true;
    }
}
