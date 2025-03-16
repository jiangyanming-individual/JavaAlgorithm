package Tree.three;

import java.util.Arrays;
import java.util.Map;

public class wiggleMaxLengthDemo {


    /**
     *
     * 动态规划的思想：
     *
     *
     * up[i] 表示以前 i 个元素中的某一个为结尾的最长的「上升摆动序列」的长度。
     * down[i] 表示以前 i 个元素中的某一个为结尾的最长的「下降摆动序列」的长度。
     *
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {
        // 数组元素为1；
        if (nums.length<2){
            return nums.length;
        }

        // 定义dp;
        int[] up=new int[nums.length];
        int[] down=new int[nums.length];

        // 长度1的长度是1
        up[0]=down[0]=1;
        for (int i=1;i<nums.length;i++) {

            //遇到山峰
            if (nums[i]>nums[i-1]){
               up[i]= Math.max(up[i-1],down[i-1] + 1);
               down[i]=down[i-1];
               // 遇到山谷
            }else if (nums[i]<nums[i-1]){
                up[i]=up[i-1];
                down[i]=Math.max(up[i-1] +1,down[i-1]);
            }else {
                //相等：
                up[i]=up[i-1];
                down[i]=down[i-1];
            }
        }
        // 取最大的
        return Math.max(up[nums.length-1],down[nums.length-1]);

    }
}
