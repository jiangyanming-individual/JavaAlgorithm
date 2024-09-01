package monotonicStack;

import java.util.Arrays;

public class trapDemo {

    /**
     * 接雨水问题： 双指针的解法
     * @param height
     * @return
     */
    public int trap(int[] height){

        //头和尾部是不接雨水的：
        if (height.length<=2) return 0;
        // 当前柱子的左边最高值
        int[] maxLeft=new int[height.length];
        // 当前柱子的右边最高值
        int[] maxRight=new int[height.length];

        maxLeft[0]=height[0];
        for (int i=1;i<height.length;i++){
            // 求左边最大的值：
            maxLeft[i] =Math.max(height[i],maxLeft[i-1]);
        }

        maxRight[height.length-1] =height[height.length-1];
        // 倒数第二个开始
        for (int i=height.length-2; i>=0;i--){
            // 求右边最大值
            maxRight[i]=Math.max(height[i],maxRight[i+1]);
        }

        // 遍历每一个柱子;
        int sum=0;
        for (int i=0;i<height.length;i++){
            // 最小的高度必须要大于0；
            int min_height=Math.min(maxLeft[i],maxRight[i]) - height[i];
            if (min_height>0){
                sum +=min_height;
            }
        }
        return sum;
    }
}
