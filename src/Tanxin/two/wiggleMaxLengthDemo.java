package Tanxin.two;

/**
 * 这题比较难解
 */
public class wiggleMaxLengthDemo {


    /**
     * 摆动子序列
     *
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (nums.length < 2) {
            return n;
        }
        int up=1;
        int down=1;
        for (int i = 1; i <nums.length ; i++) {
            if(nums[i] > nums[i-1]){
                up=Math.max(up,down + 1);
            }else if (nums[i]< nums[i-1]){
                down = Math.max(up+ 1, down);
            }
        }
        return Math.max(up,down);
    }
}



