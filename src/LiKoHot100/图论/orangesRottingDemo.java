package LiKoHot100.图论;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class orangesRottingDemo {

    /**
     * 腐烂的橘子：在 BFS 中，每一层的扩展代表 一分钟 的时间。
     */
    public int  orangesRotting(int[][] grid){

        int m = grid.length;
        int n= grid[0].length;

        Deque<int[]> deque= new LinkedList<>();


        //定义方向：
        int [][]  dir= new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        int freshOrange= 0;

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j] == 2){
                    //插入到尾部 ，push插入到头部
                    deque.offer(new int[]{i,j});
                }else if (grid[i][j] ==1){
                    freshOrange ++;
                }
            }
        }
        // 没有新鲜橘子，返回0；
        if (freshOrange == 0){
            return 0;
        }
        // 分钟
        int minutes= 0;
        while (!deque.isEmpty() && freshOrange>0){
            // 一层有多少个坏的橘子：
            int size = deque.size();
            // 每次遍历一层就加1分钟
            minutes++;
            // 先遍历一层：
            for (int i=0;i<size;i++){
                //每一个层的橘子进行出队列操作
                int[] current = deque.poll();
                int x= current[0];
                int y= current[1];
                for (int[] index : dir) {
                    int newX= x+ index[0];
                    int newY= y + index[1];
                    if (newX >=0 && newX<m && newY>=0 && newY<n && grid[newX][newY] == 1){
                        // 橘子标记为腐烂， 新的腐烂橘子入队列，新鲜橘子减一：
                        grid[newX][newY]=2;
                        deque.offer(new int[]{newX,newY});
                        freshOrange--;
                    }
                }
            }
        }
        return freshOrange == 0? minutes :-1;
    }
}
