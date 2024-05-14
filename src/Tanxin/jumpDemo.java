package Tanxin;

public class jumpDemo {

    /**
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums){
        if (nums.length == 1) return 0; //不需要跳跃

        int curCover=0; //当前能达到的最大覆盖范围
        int count=0;
        int nextCover=0; //下一步能达到的最大范围
        for (int i=0;i<nums.length;i++){
            nextCover= Math.max(nums[i] + i,nextCover); //每次更新下次可覆盖的范围；
            if (i == curCover) { //达到当前覆盖的最大范围才跳出
                count++;
                curCover =nextCover; //更新当前覆盖的最大范围；
                if (curCover >= nums.length-1){
                    break;
                }
            }
        }
        return count;
    }
}
