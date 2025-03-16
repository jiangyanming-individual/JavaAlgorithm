package Tanxin.four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class reconstructQueueDemo {


    /**
     * 重建身高：
     * 1. 先使用身高进行降序排序，
     * 2. 使用一个队列，按照k进行插入元素；
     * 3. 转为二维数组：
     * @param people
     * @return
     */
    public  int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                // 降序
                if (o1[0]!=o2[0]){
                    return o2[0] -o1[0];
                }else {
                    return o1[1] -o2[1];
                }
            }
        });
        List<int[]> list=new ArrayList<>();
        for (int[] person : people) {

            // (value,item)
            list.add(person[1],person);
        }

        int[][] array = list.toArray(new int[people.length][]);
        return array;
    }
}
