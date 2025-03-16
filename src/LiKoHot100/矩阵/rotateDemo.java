package LiKoHot100.矩阵;

public class rotateDemo {
    /**
     * 旋转图像：使用一个辅助的数组进行存储变换后的数组
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] maxtrix_new = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //变换后的数组；
                maxtrix_new[j][n- i -1]=matrix[i][j];
            }
        }

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                matrix[i][j]=maxtrix_new[i][j];
            }
        }
    }
}
