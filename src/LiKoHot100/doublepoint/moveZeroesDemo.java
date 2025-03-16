package LiKoHot100.doublepoint;

public class moveZeroesDemo {


    /**
     * 移动零
     * @param nums
     */
    public void moveZeroes(int[] nums) {

        int length= nums.length;
        // 将不是0的元素复制到前面，后面直接进行补0的操作
        int current =0;
        for (int i = 0; i < length; i++) {
            if (nums[i]!=0){
                nums[current++]= nums[i];
            }
        }

        for (int i = current; i <length ; i++) {
            nums[i]=0;
        }
    }
}
