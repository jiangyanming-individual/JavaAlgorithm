package monotonicStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class nextGreaterElement {

    /**
     * 下一个更大元素：
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1,int[] nums2){

        int[] result=new int[nums1.length];
        // 初始化全为-1；
        Arrays.fill(result,-1);
        Map<Integer, Integer> hashMap = new HashMap<>();
        // 因为num1是num2的子集
        for (int i = 0; i < nums1.length; i++) {
            hashMap.put(nums1[i],i);
        }
        // 栈
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        for (int i=1;i<nums2.length;i++){
            if (nums2[i]<=nums2[stack.peek()]){
                stack.add(i);
            }else{
              while (!stack.isEmpty() && nums2[i]>nums2[stack.peek()]){
                  // 看当前栈顶的元素是不是在num1中，如果在的话就需要取出结果：
                  if (hashMap.containsKey(nums2[stack.peek()])){
                      // 取出索引
                      Integer index = hashMap.get(nums2[stack.peek()]);
                      //存放对应打的元素：
                      result[index] =nums2[i];
                  }
                  //出栈
                  stack.pop();
              }
              //加上当前元素
              stack.add(i);
            }
        }
        return result;
    }
}
