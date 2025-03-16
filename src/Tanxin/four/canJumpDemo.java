package Tanxin.four;

public class canJumpDemo {


    public boolean canJump(int[] nums) {

        int cover=0;
        for (int i=0;i< nums.length;i++ ){
            if (i<=cover){
                cover=Math.max(cover,i + nums[i]);
                //如果最远的覆盖范围大于等于数组长度，return true;
                if (cover>= nums.length-1){
                    return true;
                }
            }
        }
        return false;
    }
}
