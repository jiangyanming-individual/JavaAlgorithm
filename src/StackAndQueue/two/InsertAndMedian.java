package StackAndQueue.two;

import java.util.ArrayList;
import java.util.List;

public class InsertAndMedian {

    private List<Integer> list=new ArrayList<>();
    public void Insert(Integer num) {
        // 为空的话直接插入：
        if (list.isEmpty()){
            list.add(num);
        }else {
            int i=0;
            for (;i<list.size();i++) {
                //如果当前元素小于等于
                if (num<=list.get(i)){
                    break;
                }
            }
            //插入，不能直接插入，容易有异常覆盖的情况
            list.add(i,num);
        }
    }

    public Double GetMedian() {
        int n= list.size();
        if (n % 2==1){
            return (double) list.get(n /2);
        }else {
            // 求两个数的平均值
            double num1=list.get(n / 2);
            double num2=list.get(n /2 -1);
            return (num1 + num2) /2;
        }
    }
}
