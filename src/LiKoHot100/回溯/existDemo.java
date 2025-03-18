package LiKoHot100.回溯;

public class existDemo {


    /**
     * 单词搜索:
     * 如果 board[i][j]
     * i!=word[k]，当前字符不匹配，直接返回 false。
     * 如果当前已经访问到字符串的末尾，且对应字符依然匹配，此时直接返回 true。
     * 否则，遍历当前位置的所有相邻位置。如果从某个相邻位置出发，能够搜索到子串 word[k+1]，则返回 true，否则返回 false。
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word){

        int m =board.length;
        int n=board[0].length;
        boolean[][] visited=new boolean[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                boolean flag = backtraversal(board, visited, word, i, j, 0);
                if (flag){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtraversal(char[][] board, boolean[][] visited, String word, int i,int j, int n){

        if (board[i][j] !=word.charAt(n)){
            return false;
        }
        // 如果n的长度等于word的长度-1 就直接返回true
        if (n == word.length()-1){
            return true;
        }
        visited[i][j]=true;
        boolean res=false;
        // 设置四个方向：
        int[][] dir= new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for (int k=0;k<dir.length;k++){
            int new_x= i + dir[k][0];
            int new_y= j+ dir[k][1];
            // 防止越界：
            if (new_x>=0 && new_x< board.length && new_y>=0 && new_y< board[0].length){
                // 如果这个点没有被访问过
                if (!visited[new_x][new_y]){
                    boolean flag = backtraversal(board, visited, word, new_x, new_y, n + 1);
                    if (flag){
                        res= true;
                        break;
                    }
                }
            }
        }
        // 回溯
        visited[i][j]=false;
        return res;
    }
}
