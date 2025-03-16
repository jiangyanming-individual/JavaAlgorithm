package Tanxin.four;

public class jumpDemo {

    public int jump(int[] nums) {
        // 一个数组元素，就不用跳
        if (nums.length == 1) return 0;

        int curCover=0;
        int nextCover=0;
        int count=0;
        for (int i=0;i< nums.length;i++){
            // 更新下一个数组的范围：
            nextCover=Math.max(nextCover,i+nums[i]);

            //如果到了当前的元素下标，还没有走到达，就更新下一个的最远距离
            if (i==curCover){
                curCover=nextCover;
                count++;
                if (curCover>= nums.length-1){
                    break;
                }
            }
        }
        return count;
    }
}
