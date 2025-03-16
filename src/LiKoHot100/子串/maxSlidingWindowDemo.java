package LiKoHot100.子串;

import java.util.Comparator;
import java.util.PriorityQueue;

public class maxSlidingWindowDemo {



    /**
     * 使用优先级队列存储：
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {


        // 结果集大小为n -k +1
        int n= nums.length;
        int[] res = new int[n - k + 1];


        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            //自定义比较的规则
            @Override
            public int compare(int[] o1, int[] o2) {
                // 如果元素不相等，先按元素大小进行降序排列，如果相等，安装元素index进行降序排列
                return o1[0] != o2[0] ? o2[0] -o1[0] : o2[1] -o1[1];
            }
        });
        // 初始化，先将前k元素加入到队列中；
        for (int i=0;i<k;i++){
            priorityQueue.add(new int[]{ nums[i],i});
        }
        // 加入第一个窗口的最大值：
        res[0]=priorityQueue.peek()[0];

        // 往后移动
        for (int i=k;i<n;i++){
            // 每次往队列中加入新的元素：
            priorityQueue.add(new int[]{nums[i],i});
            // 如果当前的优先级队列中元素已经超过了范围，也要删除掉：
            while (priorityQueue.peek()[1] <= i -k){
                priorityQueue.poll();
            }
            // 每次取出最大的元素放入到数组中：
            res[i - k +1] = priorityQueue.peek()[0];
        }

        return res;
    }

}
