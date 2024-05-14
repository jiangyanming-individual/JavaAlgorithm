package Tanxin;

public class canJumpDemo {

    public boolean canJump(int[] nums) {

        //看覆盖的范围能否超过长度
        int cover=0;
        for (int i=0;i<=cover;i++){
            cover=Math.max(cover,i+nums[i]);

            //num.length-1取不到
            if (cover>= nums.length-1){
                return true;
            }

        }
        return false;
    }

}
