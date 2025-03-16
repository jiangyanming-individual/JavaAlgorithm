package LiKoHot100.贪心;

public class jumpDemo {


    /**
     * 跳跃游戏2：
     如果当前数组元素为1， 直接返回0
     * 1. 当前的覆盖范围curCover，下一次的覆盖范围nextCover
     * 2. 获取到下一次的最大覆盖范围，max(i + nums[i],nextCover)
     * 3. 如果遍历到当前的覆盖范围后，更新将下一次的覆盖范围赋值给当前的覆盖范围。
     *  当前的覆盖范围>= nums.length 就直接结束。
     * @param nums
     * @return
     */
    public int jump(int[] nums){
        if (nums.length  == 1){
            return 0;
        }
        // 当前覆盖范围
        int curCover=0;
        // 下一步的覆盖范围
        int nextCover =0;
        // 统计次数：
        int count=0;
        for (int i=0;i<nums.length;i++) {
            nextCover = Math.max(i + nums[i], nextCover);
            if (i == curCover) {
                curCover = nextCover;
                count++;
                //如果当前下标超过了nums.length -1 就可以直接结束
                if (curCover >= nums.length-1) {
                    break;
                }
            }
        }
        return count;
    }
}
