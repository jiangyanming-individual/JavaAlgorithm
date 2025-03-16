package LiKoHot100.数组;

public class productExceptSelfDemo {


    /**
     * 左右侧乘积： 下标index =i的左右侧乘积的结果：
     * 左侧： L[i] = nums[i-1] * L[i-1];
     * 右侧：R[i] = nums[i+1] * R[i+1];
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {


        int length = nums.length;

        // L 和 R 分别表示左右两侧的乘积列表
        int[] L = new int[length];
        int[] R = new int[length];

        int[] res = new int[length];

        // 初始化： 下标0的左侧和下标length -1 的右侧：
        L[0] =1;
        R[length -1] =1;
        // 左侧：
        for (int i=1;i<length;i++){
            L[i] = nums[i-1]  * L[i-1];
        }
        // 右侧：
        for (int i= length-2 ;i>=0;i--){
            // 当前i
            R[i] = nums[i+1] * R[i+1];
        }
        for (int i=0;i<length;i++){
            res[i]  =L[i] * R[i];
        }

        return res;

    }
}
