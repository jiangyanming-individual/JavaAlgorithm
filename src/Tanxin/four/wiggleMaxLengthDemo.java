package Tanxin.four;

public class wiggleMaxLengthDemo {

    public int wiggleMaxLength(int[] nums) {

        //如果数组长度小于2，则为1；
        if (nums.length<2) {
            return nums.length;
        }

        // dp,表示索引下标为i的最大连续摆动子序列
        int[] up=new int[nums.length]; // 上升序列的最大长度；
        int[] down=new int[nums.length]; // 下降序列最大长度
        //初始化
        up[0]=down[0]=1;
        for (int i=1;i<nums.length;i++){

            if (nums[i]>nums[i-1]){
                //山峰
                up[i]=Math.max(up[i-1], down[i-1] +1);
                down[i]=down[i-1];
            }else if (nums[i]<nums[i-1]){
                //山谷；
                up[i]=up[i-1];
                down[i]=Math.max(down[i-1],up[i-1] +1);
            }else {
                //平的
                up[i]=up[i-1];
                down[i]=down[i-1];
            }
        }
        // 取两者之间最大的值：
        return Math.max(up[nums.length-1],down[nums.length-1]);
    }



}
