package LiKoHot100.树;

import java.util.ArrayList;
import java.util.List;

public class generateDemo {


    /**
     * 生成杨辉三角：
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();
        for (int i=0;i<numRows;i++){
            List<Integer> tempList= new ArrayList<>();
            for (int j=0;j<=i;j++){
                if (j== 0 || i == j){
                    tempList.add(1);
                }else {
                    // nums[i-1][j-1] + nums[i-1][j]
                    tempList.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
                }
            }
            res.add(tempList);
        }
        return res;
    }
}
