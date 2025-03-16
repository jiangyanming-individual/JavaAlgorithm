package LiKoHot100.数组;

public class productExceptSelfDemo2 {


    /**
     * 左右侧乘积： 下标index =i的左右侧乘积的结果：
     * 左侧： L[i] = nums[i-1] * L[i-1];
     * 右侧：R[i] = nums[i+1] * R[i+1];
     *
     * 进行遍历数组的操作: res[i] =LTable[i] * RTable[i]
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {

        int length = nums.length;

        // 左侧乘积和，下标index =i的左侧乘积和
        int[] LTable=new int[length];
        // 右侧乘积和， 下标index= i的右侧乘积和
        int[] RTable=new int[length];
        int[] res =new int[nums.length];

        // 初始化：
        LTable[0] =1;
        RTable[length-1]=1;

        for (int i=1;i<nums.length;i++){
            LTable[i] = nums[i-1] * LTable[i-1];
        }

        for (int i=length-2;i>=0;i--){
            RTable[i] =nums[i+1] * RTable[i+1];
        }
        // 进行数组求乘积
        for (int i=0;i<length;i++){
            res[i] = LTable[i] * RTable[i];
        }
        return res;
    }
}
