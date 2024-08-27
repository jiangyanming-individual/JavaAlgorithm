package DpQuestion.two;

public class findLengthDemo {

    /**
     * 最长重复子数组：实际上求的连续的相同数组的长度。
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength(int[] nums1, int[] nums2){

        // 定义dp, 表示下标为i-1, j-1的数组相等的长度
        int[][] dp=new int[nums1.length+1][nums2.length+1];
        // 初始化dp； dp[i][0] 和 dp[0][j]都初始化为0；
        for (int i=0;i<nums1.length;i++){
            dp[i][0]=0;
        }
        for (int j=0;j<nums2.length;j++){
            dp[0][j]=0;
        }
        int result=0;
        for (int i = 1; i <= nums1.length; i++) {
            for (int j=1;j<=nums2.length;j++){
                if (nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                if (dp[i][j]>result) result=dp[i][j];
            }
        }
        return result;
    }
}
