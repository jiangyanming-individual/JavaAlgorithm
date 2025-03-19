package LiKoHot100.技巧;

public class sortColorsDemo {


    /**
     * 颜色分类：
     * @param nums
     */
    public void sortColors(int[] nums){

        int pre=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i] == 0){
                int temp=nums[i];
                nums[i]= nums[pre];
                nums[pre]= temp;
                pre++;
            }
        }

        for (int i=pre;i<nums.length;i++){
            if (nums[i] == 1){
                int temp =nums[i];
                nums[i]= nums[pre];
                nums[pre] =temp;
                pre++;
            }
        }
    }
}
