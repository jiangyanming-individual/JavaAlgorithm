package LiKoHot100.技巧;

public class nextPermutationDemo {


    /**
     * 1. 倒序找到第一个不是倒序排列的， 然后倒序找到第一个比他大的数
     * 2. 翻转+ 赋值。
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        // 倒序；
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = n - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums,i,j);
        }
        // 从i+1
        reverse(nums,i+1);
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 翻转：
    public void reverse(int[] nums, int left) {
        int right = nums.length - 1;
        while (left <= right) {
            swap(nums,left,right);
            left++;
            right--;
        }
    }
}
