package DpQuestion;

public class lastStoneWeightIIDemo {

    public int lastStoneWeight(int[] stones){
        int sum=0;
        for (int i=0;i<stones.length;i++){
            sum +=stones[i];
        }
        //背包容量；
        int target=sum /2 ;
        int[]  dp = new int[target + 1]; //能查找到dp[target]
        for (int i=0;i<stones.length;i++){
            for (int j=target;j>=stones[i];j--){
                //更新最大dp：
                dp[j] =Math.max(dp[j-stones[i]] + stones[i],dp[j]);
            }
        }
        return  sum - dp[target] - dp[target]; //剩余石头的重量，或者价值；
    }
}
