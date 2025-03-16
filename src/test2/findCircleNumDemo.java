package test2;

public class findCircleNumDemo {


    public int findCircleNum(int[][] isConnected) {

        int res =0;
        int n= isConnected.length;

        int count1=0;
        int connect=0;
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (isConnected[i][j] == 1  && i!=j){
                    connect++;
                }else if (isConnected[i][j] == 1 && i == j){
                    count1++;
                }
            }
        }
        res =count1-connect /2;
        return res;
    }
}
