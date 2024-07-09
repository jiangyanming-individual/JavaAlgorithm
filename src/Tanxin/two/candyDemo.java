package Tanxin.two;

import java.lang.reflect.Array;
import java.util.Arrays;

public class candyDemo {

    public int candy(int[] ratings) {

        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);

        //从前往后；右大左；
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i + 1] > ratings[i]) {
                candy[i + 1] = candy[i] + 1;
            }
        }
        //从后往前，左大于右
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                //比较，拿出最大的
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
        }
        return Arrays.stream(candy).sum();
    }
}
