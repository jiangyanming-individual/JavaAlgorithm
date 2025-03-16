package LiKoHot100.doublepoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSumDemo {

    /**
     * 三数之和：不含重复的
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {


        // 升序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            // a去重复
            if (i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            // 双指针找b和c
            int left =i+1;
            int right =nums.length-1;

            int target = -nums[i];
            while (left <right){

                // sum求和的操作：
                int sum = nums[left] + nums[right];
                if (sum == target){
                    // 取得结果
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));

                    // 指针移动
                    left++;
                    right--;
                    // b和c去重复；
                    while (left<right && nums[left] == nums[left-1]){
                        left++;
                    }
                    while (left<right && nums[right] == nums[right+1]) {
                        right--;
                    }

                }else if (sum< target){
                    // 如果求和的操作小于target就进行左指针进行右移动操作
                    left++;
                }else {
                    right--;
                }
            }
        }
        return result;
    }
}
