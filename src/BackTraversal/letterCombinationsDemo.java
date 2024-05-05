package BackTraversal;

import java.util.ArrayList;
import java.util.List;

public class letterCombinationsDemo {

    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     */
    List<String> result=new ArrayList<>();
    StringBuilder stringBuilder = new StringBuilder();

    public List<String> letterCombinations(String digits){
        //考虑特殊的情况：
        if (digits == null || digits.length() == 0){
            return result;
        }
        // 数字对应的字符集
        String [] stringNumerMap={"", "" ,"abc", "def","ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtraversal(digits,stringNumerMap,0);
        return result; //返回结果
    }

    public void backtraversal(String digits, String[] stringNumerMap ,int index){

        //digits 的长度 == stringBuilder的长度
        if (digits.length() == stringBuilder.length()){
            result.add(stringBuilder.toString());
            return;
        }
        //得到数字对应的字符：
        String str = stringNumerMap[digits.charAt(index) - '0'];
        //遍历字符：[0,length -1]
        for (int i=0;i<str.length();i++){
            stringBuilder.append(str.charAt(i));
            backtraversal(digits,stringNumerMap,index+1); //查找digits 的下一个元素
            stringBuilder.deleteCharAt(stringBuilder.length()-1);//  回溯，删除最后一个元素；
        }

    }
}
