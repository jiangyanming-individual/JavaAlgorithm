package DpQuestion.two;

public class maxProfitDemo2 {

    /**
     * 买卖股票的最佳时机：
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int result=0;
        for (int i=1;i<prices.length;i++){

            if ((prices[i] - prices[i-1])>0){
                result+= prices[i] - prices[i-1];
            }
        }
        return result;
    }
}
