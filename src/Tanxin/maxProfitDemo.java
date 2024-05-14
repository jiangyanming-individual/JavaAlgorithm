package Tanxin;

public class maxProfitDemo {

    /**
     * 贪心算法：
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        //以两天为一个周期，前一天减去当前的价格：
        int result= 0;
        for (int i=1;i<prices.length;i++){
            result+= Math.max(prices[i]-prices[i-1],0);
        }
        return result;
    }

}
