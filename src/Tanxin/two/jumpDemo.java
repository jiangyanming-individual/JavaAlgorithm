package Tanxin.two;

public class jumpDemo {

    public int jump(int[] nums) {

        if (nums.length == 0 || nums.length == 1) return 0;

        //统计次数
        int count = 0;
        //覆盖范围
        int curCover = 0;
        int nextCover = 0;
        for (int i = 0; i < nums.length; i++) {
            //更新下一次的最大覆盖距离
            nextCover = Math.max(i + nums[i], nextCover);
            //说明下一次能直接到达：提前结束
            if (nextCover >= nums.length - 1) {
                count++;
                break;
            }
            //如果到达当前最大的覆盖范围,更新当前的最大范围为下一次的覆盖范围；统计次数加1
            if (i == curCover) {
                curCover = nextCover;
                count++;
            }
        }
        return count;
    }
}
