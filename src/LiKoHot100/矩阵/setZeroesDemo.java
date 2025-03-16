package LiKoHot100.矩阵;

public class setZeroesDemo {


    /**
     * 1.矩阵置零操作： 使用两个行和列的数组进行标记，如果当前的matrix[i][j] ==0, rows[i] =true, cols[j] =true
     * 2. 遍历矩阵，只要行或者列有一个是true，那么当前的矩阵值就设置为0
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {


        int m = matrix.length;
        int n = matrix[0].length;

        // 行大小
        boolean[] rows= new boolean[m];
        // 列大小
        boolean[] cols=new boolean[n];

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (matrix[i][j] == 0){
                    rows[i]= true;
                    cols[j]=true;
                }
            }
        }
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){

                // 只要行或者列有一个是true就直接将矩阵的值设置0
                if (rows[i] || cols[j]){
                    matrix[i][j]=0;
                }
            }
        }
    }
}
