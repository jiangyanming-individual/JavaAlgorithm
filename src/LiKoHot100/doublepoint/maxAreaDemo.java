package LiKoHot100.doublepoint;

public class maxAreaDemo {

    /**
     * 盛最多水的容器：思路 = 高度 * 长度
     * @param height
     * @return
     */
    public int maxArea(int[] height){


        int left =0,right = height.length -1;
        int result =0;

        while (left < right){
            // 取短板：
            int area = Math.min(height[left], height[right]) * (right -left);
            // 比较结果，取较大的结果：
            result = Math.max(area, result);
            // 较小的那一段移动；指针进行移动的操作
            if (height[left]<height[right]){
                left++;
            }else {
                right -- ;
            }
        }
        return result;
    }
}
