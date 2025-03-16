package LiKoHot100.图论;

import java.util.Deque;
import java.util.LinkedList;

public class orangesRottingDemo2 {


    public int orangesRotting(int[][] grid){
        int m= grid.length;
        int n= grid[0].length;
        int freshOrange =0;
        int[][] directions = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        Deque<int[]> deque=new LinkedList<>();
        // 所需要的分钟数：
        int minutes=0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j] ==2){
                    deque.offer(new int[] {i,j});
                }else if (grid[i][j] ==1){
                    freshOrange++;
                }
            }
        }

        if (freshOrange == 0) {
            return 0;
        }

        //深度优先遍历：
        while (!deque.isEmpty() && freshOrange>0){
            int size = deque.size();
            // 每遍历一层进行加1的操作
            minutes++;
            for (int i=0;i<size;i++){
                int[] current = deque.poll();
                int x= current[0];
                int y= current[1];
                for (int[] direction : directions) {
                    int newX= x + direction[0];
                    int newY= y + direction[1];
                    if (newX>=0 && newX<m && newY>=0 && newY<n && grid[newX][newY] == 1){
                        // 将新橘子腐烂，并且入队列， 然后新橘子减一
                        deque.offer(new int[]{newX,newY});
                        grid[newX][newY] =2;
                        freshOrange--;
                    }
                }
            }
        }
        return freshOrange == 0 ? minutes : -1;
    }
}
