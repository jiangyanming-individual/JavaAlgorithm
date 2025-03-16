package LiKoHot100.数组;

public class rotateDemo {


    /**
     * 轮转数组: 使用翻转的思想，
     *      避免出现k大于数组长度的情况， 要对k 进行取余的操作
     * （1） 先翻转0-n-1 7654321
     *  (2) 翻转 0-k-1  5674321
     *  (3) 翻转 k-n-1  5671234
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {

        // 避免出现k大于数组长度的情况
        k %=nums.length;
        int n =nums.length;
        reverse(nums,0,n-1);
        reverse(nums, 0,k-1);
        reverse(nums,k, n-1);

    }

    public void  reverse(int[] nums,int start, int end){

        while (start<end){
            int temp= nums[start];
            nums[start]= nums[end];
            nums[end]= temp;
            start++;
            end--;
        }
    }
}
