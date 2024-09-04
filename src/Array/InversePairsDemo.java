package Array;

import java.util.Scanner;

public class InversePairsDemo {


    /**
     * 逆序对，归并排序
     */
    public static int mod=1000000007;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] parts = input.split(",");
        int[] arr=new int[parts.length];
        // 赋值操作：
        for (int i=0;i< arr.length;i++){
            arr[i]= Integer.parseInt(parts[i]);
        }
        InversePairs(arr);
    }

    public static int InversePairs (int[] nums) {
        int left=0;
        int right=nums.length-1;
        int[] temp=new int[nums.length];
        return merge(left,right,nums,temp);
    }
    public static int  merge(int left,int right,int[] data ,int[] temp){
        //递归停止：
        if (left>=right)
            return 0;
        int mid= (right + left)/ 2;
        int res=merge(left,mid,data,temp) + merge(mid + 1,right,data,temp);
        //防止溢出
        res %=mod;
        // 左右区间的起点：
        int i=left, j=mid + 1;
        for (int k=left;k<=right;k++) {
            // 临时数组：
            temp[k]=data[k];
        }
        for (int k=left;k<=right;k++){
            if (i==mid +1){
                data[k]=temp[j++];
                // i<j
            }else if(j== right +1 || temp[i]<=temp[j]){
                data[k]=temp[i++];
            }else {
                // i>j; 取小的值
                data[k]=temp[j++];
                // 统计逆序对
                res += mid -i + 1;
            }
        }
        // 取模就是取余数：
        System.out.println("最后的结果为：" + (res % mod));
        return res % mod;
     }
}
