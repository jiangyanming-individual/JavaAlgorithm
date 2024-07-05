package Tanxin.two;

public class canJumpDemo {


    /**
     * 最大跳跃间隙
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {

        if (nums.length == 1) {
            return true;
        }
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            //更新能覆盖的范围
            cover = Math.max(i + nums[i], cover);
            if (cover >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
