package Tanxin.three;

import java.util.*;

public class reconstructQueueDemo {



    /**
     * 1. 首先按照身高进行降序排列，如果身高相等就按照k进行升序排列
     * 2. 使用一个LinkedList按照k进行插入
     * 3. 将list转为二维数组：
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int [][] nums=new int[n][2];

        for (int i=0;i<nums.length;i++){
            for (int j=0;j<2;j++){
                nums[i][j]=scanner.nextInt();
            }
        }
        int[][] ints = reconstructQueue(nums);

        for (int[] item : ints) {
            System.out.println(item[0] + " " + item[1]);
        }
    }
    /**
     * 根据身高重建队列
     * @param people
     * @return
     */
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //按身高降序
                if (o1[0]!=o2[0]){
                    return o2[0] -o1[0];
                }else {
                    // 如果身高相等，按照k进行升序排列，看前面有几个人是比当前的人高的
                    return o1[1] -o2[1];
                }

            }
        });
        // 链表
        List<int[]> list=new ArrayList<>();

        for (int[] person : people) {
            // 按照前面有多少个比自己高的人进行插入操作；
            list.add(person[1],person);
        }
        int[][] array = list.toArray(new int[people.length][]);

        return array;
    }
}
