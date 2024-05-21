package Tanxin;

import java.util.Arrays;
import java.util.LinkedList;

public class reconstructQueueDemo {

    /**
     * 先高度降序排列，然后按第二维度元素升序排列
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        //先排序：
        Arrays.sort(people,(a,b)->{ //实现了Comparator 接口
            if (a[0] == b[0]) {
                return a[1] - b[1]; //升序
            }
            return b[0] - a[0]; //按身高降序
        });

        //新建一个链表
        LinkedList<int[]> linkedList = new LinkedList<>();
        for (int[] person : people) {
            linkedList.add(person[1],person); ///Linkedlist.add(index, value)，value 根据index插入到集合中。
        }
        //返回结果
        return linkedList.toArray(new int[people.length][]);
    }
}
