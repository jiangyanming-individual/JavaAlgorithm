package Tanxin.three;

public class canJumpDemo {


    /**
     * 跳跃游戏
     * 1. 维护一个最远距离的下标：index：
     * 2. 遍历数组，每次更新最远距离；
     * 3. 判断如果最远距离大于当前数组下标就直接返回
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {

        //维护最远的位置：remote
        int remote=0;
        for (int i=0;i<nums.length;i++){

            if (i<=remote){
                remote=Math.max(remote, i + nums[i]); //更新最远的位置：
                // 如果说当前最远的位置已经超过数组的下标，说明就可以到达
                if (remote>=nums.length-1){
                    return true;
                }
            }
        }

        return false;
    }
}
