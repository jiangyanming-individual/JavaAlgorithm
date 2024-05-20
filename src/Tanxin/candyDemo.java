package Tanxin;

import java.util.Arrays;

public class candyDemo {

    /**
     * 分发糖果：分左孩子大于右孩子和右孩子大于左孩子两种情况遍历
     * @param ratings
     * @return
     */
    public int candy(int[] ratings){
        //1. 从前往后遍历，右孩子大于左孩子 (rating[i+1]>rating[i]==> candy[i+1]= candy[i] + 1;)
        int sum=0; //总的分发糖果数
        int[] candy = new int[ratings.length];
        Arrays.fill(candy,1);
        for (int i = 0; i < ratings.length-1; i++) {
            if (ratings[i+1] > ratings[i]){
                candy[i+1]=candy[i] + 1; //左孩子加1
            }
        }

        //2. 从后往前遍历，左孩子大于右孩子 (rating[i]>rating[i+1])
        for (int i = ratings.length-2; i >=0; i--) {
            if (ratings[i]> ratings[i+1]){
                candy[i] = Math.max(candy[i+1]+1, candy[i]); // 右边 + 1 和原先的candy[i]相比；
            }
        }
        //返回最后的结果，遍历相加
        return Arrays.stream(candy).sum();
    }

}
