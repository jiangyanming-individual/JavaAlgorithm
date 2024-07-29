package Tanxin.three;

public class lemonadeChangeDemo {


    public boolean lemonadeChange(int[] bills) {

        int fiveCount = 0;
        int tenCount = 0;

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

                //优先花10 和 5
                if (tenCount > 0 && fiveCount > 0) {
                    fiveCount--;
                    tenCount--;
                } else if (fiveCount >= 3) {
                    fiveCount -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
