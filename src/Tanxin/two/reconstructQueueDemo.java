package Tanxin.two;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class reconstructQueueDemo {


    /**
     * 根据身高排队
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {

        //先按身高降序，然后如果相等，按升序；
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });

        List<int[]> list = new LinkedList();

        //根据前面有多少个人这个 index再进行插入
        for (int[] person : people) {
            list.add(person[1], person);
        }
        return list.toArray(new int[people.length][]);
    }
}
