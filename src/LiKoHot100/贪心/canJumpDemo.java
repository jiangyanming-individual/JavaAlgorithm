package LiKoHot100.贪心;

public class canJumpDemo {


    /**
     * 能跳到最远距离：
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums){

        int n = nums.length;
        int coverIndex=0;
        for (int i=0;i<n;i++){
            if (i<=coverIndex){
                // 更新最长的边界
                coverIndex= Math.max(coverIndex, i + nums[i]);
                // 判断当前的下标能不能
                if (coverIndex>= nums.length-1){
                    return true;
                }
            }
        }
        return false;
    }
}
