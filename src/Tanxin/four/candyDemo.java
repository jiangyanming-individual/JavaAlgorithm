package Tanxin.four;

import java.util.Arrays;
import java.util.Scanner;

public class candyDemo {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();

        int[] nums=new int[n];
        for (int i=0;i<nums.length;i++){
            nums[i]=scanner.nextInt();
        }

        int candy = candy(nums);

    }

    /**
     * 分发糖果：
     *
     * 1.从左往右进行遍历，如果nums[i]>nums[i-1] candy[i]=candy[i-1] +1;
     * 2.从右往左进行遍历： 如果nums[i]> nums[i+1] , candy[i] = max(candy[i], candy[i+1] +1);
     * 3. 对candy 进行统计求和；
     * 4. 至少每个人得一个糖果：
     * @param ratings
     * @return
     */
    public static int candy(int[] ratings) {

        int[] candy=new int[ratings.length];
        // 每个小孩子至少得1个糖果
        Arrays.fill(candy,1);
        // 从左往右
        for (int i=1;i<ratings.length;i++){
            if (ratings[i]>ratings[i-1]){
                candy[i]=candy[i-1] +1;
            }
        }
        // 从右往左
        for (int i=ratings.length-2;i>=0;i--){
            if (ratings[i]>ratings[i+1]){
                candy[i]=Math.max(candy[i],candy[i+1] +1);
            }
        }

        int sum = Arrays.stream(candy).sum();
        System.out.println(sum);
        return sum;
    }
}
