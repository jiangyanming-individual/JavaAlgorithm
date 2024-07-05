package Tanxin.two;

public class maxProfitDemo {


    /**
     * 最大利润
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices){

        int max_profit=0;
        for (int i = 1; i <prices.length ; i++) {
            //每两天只去正利润,如果为负，直接取0
            max_profit += Math.max(prices[i] -prices[i-1],0);
        }
        return max_profit;
    }
}
