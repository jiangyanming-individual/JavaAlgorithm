package LiKoHot100.图论;

public class numIslandsDemo {


    /**
     * 岛屿数量： 图论，实现使用深度优先搜索
     * @param grid
     * @return
     */
    public int numsIslands(char[][] grid){

        if (grid == null || grid.length == 0){
            return 0;
        }

        int m= grid.length;
        int n=grid[0].length;
        int res= 0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j] == '1'){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        // 返回结果：
        return res;
    }


    // 深度优先遍历
    public void  dfs(char[][] grid , int curM, int curN){
        int m= grid.length;
        int n= grid[0].length;

        // 不符合条件，越界的都直接返回
        if (curM<0 || curN<0 || curN>= n || curM>= m || grid[curM][curN] == '0'){
            return;
        }
        // 遍历过后，直接设置为0
        grid[curM][curN] = '0';
        // 在当前节点左右前后
        dfs(grid, curM-1, curN);
        dfs(grid,curM+1, curN);
        dfs(grid,curM,curN-1);
        dfs(grid,curM,curN+1);
    }
}
