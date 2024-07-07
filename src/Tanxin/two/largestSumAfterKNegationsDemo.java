package Tanxin.two;

import java.util.Arrays;
import java.util.stream.IntStream;

public class largestSumAfterKNegationsDemo {

    public int largestSumAfterKNegations(int[] nums, int k) {

        //降序排列：
        int[] resNums = IntStream.of(nums).boxed().sorted((o1, o2) -> {
            return Math.abs(o2) - Math.abs(o1);
        }).mapToInt(Integer::intValue).toArray();

        for (int i = 0; i < resNums.length; i++) {
            if (resNums[i] < 0 && k > 0) {
                resNums[i] = -resNums[i];
                k--;
            }
        }


        //如果k最后还剩下，就取反最后一个
        if (k % 2 == 1) {
            resNums[resNums.length - 1] = -resNums[resNums.length - 1];
        }
        //求和
        return Arrays.stream(resNums).sum();
    }
}
