package monotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class nextGreaterElementsDemo2 {

    /**
     * 下一个更大元素2
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums){

        if (nums.length == 1) return new int[]{-1};
        int size=nums.length;
        int[] result=new int[nums.length];
        // 初始化为-1；
        Arrays.fill(result,-1);
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        //长度取余；
        for (int i=0;i<size * 2 ;i++){
            if (nums[i % size]<=nums[stack.peek()]){
                // index进行取余操作
                stack.add(i % size);
            }else {
                while (!stack.isEmpty() && nums[i % size]>nums[stack.peek()]){
                    result[stack.peek()] =nums[i % size];
                    stack.pop();
                }
                // 加入当前的值：
                stack.add(i % size);
            }
        }
        return result;
    }
}
