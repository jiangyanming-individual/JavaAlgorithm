package LiKoHot100.图论;

import java.util.LinkedList;
import java.util.Queue;

public class findCircleNumDemo {


    /**
     * 找到省份：使用广度优先搜索+  使用队列实现：
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected){

        int res =0;
        int n= isConnected.length;
        Queue< Integer> queue=new LinkedList<>();
        boolean[] isVisited = new boolean[n];
        for (int i=0;i<n;i++){
            // 如果没有被访问过
            if (!isVisited[i]){
                queue.add(i);
                while (!queue.isEmpty()){
                    int city = queue.poll();
                    // 将当前节点设置为访问过的节点：
                    isVisited[city] =true;
                    for (int j=0;j<n;j++){
                        // 如果当前节点连同，而且没有访问过，加入到队列里面
                        if (isConnected[city][j] == 1 && !isVisited[j]){
                            queue.add(j);
                        }
                    }
                }
                res++;
            }
        }
        // 返回结果
        return res;
    }
}
