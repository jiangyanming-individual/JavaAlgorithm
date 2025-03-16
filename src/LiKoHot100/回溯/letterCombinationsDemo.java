package LiKoHot100.回溯;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class letterCombinationsDemo {


    /**
     (1)先使用一个HashMap 存储'数字' 对应的字符串。
     (2)使用一个StringBuilder 来存放每次结果。然后回溯传入（str，index）,  index是指当前遍历到哪个字母。
     (3)回溯过程，终止条件 if (index == str.length()) 表示所有的字符都取完了，可以收获结果了。就将StringBuilder的结果存到result中。
     (4) 回溯中，每次map.get(str.chatAt(index)) 取出对应的字符串，然后进行遍历。StringBuilder 取结果，然后index +1 表示遍历下一个字符数字，然后删除StringBuilder 的最后一个元素。
     */

    List<String>  res =new ArrayList<>();
    StringBuffer buffer=new StringBuffer();
    public List<String> letterCombinations(String digits){
        if (digits.length() == 0 || digits == null){
            return res;
        }
        // 进行字符存储成一个hashmap
        HashMap<Integer, String> hashMap = new HashMap(){{
            put(0,"");
            put(1,"");
            put(2,"abc");
            put(3,"def");
            put(4,"ghi");
            put(5,"jkl");
            put(6,"mno");
            put(7,"pqrs");
            put(8,"tuv");
            put(9,"wxyz");
        }};
        traversal(digits,hashMap,0);
        return res;
    }
    public void traversal(String str, Map<Integer,String> map, int index){

        if (index == str.length()){
            // 取结果集
            res.add(buffer.toString());
            return;
        }
        // 取数字对应的hashmap存储的字符串
        String s = map.get(str.charAt(index) -'0');
        for (int i=0;i<s.length();i++){
            // 取对应字符
            buffer.append(s.charAt(i));
            traversal(str,map,index+1);
            // 回溯
            buffer.deleteCharAt(buffer.length() -1);
        }
    }
}
