package DpQuestion;

/**
 * 01背包问题使用二维数组：
 */
public class zero_one_pack {

    public static void main(String[] args) {
        getMaxValue();
    }

    public static int getMaxValue(){
        int[] weights= new int[]{2,2,3,1,5,2};
        int[] values = new int[]{2,3,1,5,4,3};
        int size= 6;
        int packWeight = 6;

        int[][]  dp= new int[size][packWeight+1]; //物品个数不需要扩容

        //初始化dp
        //小于物品0的重量全部初始化为0；
        for (int j = 0; j< weights[0]; j++) {
            dp[0][j]=0;
        }
        for (int j=weights[0];j<=packWeight;j++){
            dp[0][j]=values[0];
        }

        //递推公式 dp[i][j]=max(dp[i-1][j],dp[i-1][j-weights[i]] + values)
        //确定遍历顺序,先遍历物品，再遍历背包
        for (int i = 1; i <size; i++) {
            for (int j=0;j<=packWeight;j++){
                if (j< weights[i]){
                    dp[i][j]= dp[i-1][j];
                }else {
                    dp[i][j] =Math.max(dp[i-1][j],dp[i-1][j-weights[i]] + values[i]);
                }
            }
        }
        //先遍历背包，再遍历物品。物品的第一个不用遍历，因为已经初始化过了。
//        for (int j=0;j<=packWeight;j++){
//            for (int i=1;i<=size;i++){
//                if (j< weights[i]){
//                    dp[i][j]=dp[i-1][j];
//                }else {
//                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weights[i]]+values[i]);
//                }
//            }
//        }
        //模拟 获取结果：
        for (int i=0;i<size;i++){
            for (int j=0;j<=packWeight;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("result:" + dp[size-1][packWeight]);
        return dp[size-1][packWeight];
    }
}
