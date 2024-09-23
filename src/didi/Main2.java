package didi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {


    public static void main(String args[]) {
        int T;
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        for (int i=0;i<T;i++){
            //n 行
            int n= scanner.nextInt();
            int[][] nums=new int[n][2];
            for (int k=0;k<n;k++){
                for (int j=0;j<2;j++){
                    nums[k][j]= scanner.nextInt();
                }
            }
            String result = getResult(nums);
            System.out.println(result);
        }
        scanner.close();
    }

    public static String getResult(int[][] nums) {

        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<n;i++){
            map.put(nums[i][0] + nums[i][1],map.getOrDefault(nums[i][0]+ nums[i][1],0) +1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value>1){
                return "NO";
            }
        }
        return "YES";
    }
}

