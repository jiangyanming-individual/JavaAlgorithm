package DpQuestion.two;

/**
 * 完全背包理论：一个物品可以使用多次：先遍历物品还是先遍历背包都无所谓
 */
public class testCompletePackDemo {

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < weight.length; i++) {
            //先遍历物品，再遍历背包：
            for (int j = weight[i]; j <= bagWeight; j++) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        System.out.println("完全背包的结果："+dp[bagWeight]);
    }


}
