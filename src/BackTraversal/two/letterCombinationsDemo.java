package BackTraversal.two;

import java.util.ArrayList;
import java.util.List;

public class letterCombinationsDemo {


    List<String> result = new ArrayList<>();
    StringBuilder stringBuilder = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        //剪枝操作：
        if (digits.length() == 0 || digits == null) {
            return result;
        }
        //对应字符的map:
        String[] digitsMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        traversal(digits, digitsMap, 0);
        return result;
    }

    public void traversal(String digits, String[] digitsMap, int index) {
        //收集结果
        if (index == digits.length()) {
            result.add(stringBuilder.toString());
            return;
        }
        //取到对应的字符串
        String str = digitsMap[digits.charAt(index) - '0'];
        for (int i = 0; i < str.length(); i++) {
            stringBuilder.append(str.charAt(i));
            //递归：查找下一个数值
            traversal(digits, digitsMap, index + 1);
            //移除最后一个
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

}
