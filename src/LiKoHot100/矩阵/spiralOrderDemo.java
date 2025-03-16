package LiKoHot100.矩阵;

import java.util.ArrayList;
import java.util.List;

public class spiralOrderDemo {

    /**
     * 螺旋矩阵： 思想就是模拟进行操作
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        int left =0;
        int right = n-1;
        int top =0;
        int bottom =m-1;

        // 终止条件：列表的大小小于整个矩阵数量的和
        while (res.size()< m * n){
            //从左上到右上
            if (top<=bottom){
                for (int j=left;j<=right;j++){
                    res.add(matrix[top][j]);
                }
                top++;
            }
            // 从右上到右下
            if (left<=right){
                for (int i=top;i<=bottom;i++){
                    res.add(matrix[i][right]);
                }
                right--;
            }
            // 从右下到左下
            if (top<=bottom){
                for (int j=right;j>=left;j--){
                    res.add(matrix[bottom][j]);
                }
                bottom--;
            }
            // 从左下到左上
            if (left<=right){
                for (int i=bottom;i>=top;i--){
                    res.add(matrix[i][left]);
                }
                //左指针右移动
                left++;
            }
        }
        return res;
    }
}
