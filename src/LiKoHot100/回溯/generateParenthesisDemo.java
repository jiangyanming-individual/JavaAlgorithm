package LiKoHot100.回溯;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesisDemo {

    /**
     * 有效的括号生成：
     * (1)当左括号和右括号的数量都等于 n 时，将当前组合添加到结果列表中
     * (2) 如果左括号小于n， 那就加入左括号, 然后进行回溯
     * (3) 如果右括号小于左括号， 那就加入右括号，然后进行回溯
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {

        List<String> res =new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer();
        backTraversal(res,stringBuffer,0,0,n);
        return res;
    }
    public void backTraversal(List<String> res ,StringBuffer currentStr,int open, int close,int n){
        // 当左括号和右括号的数量都等于 n 时，将当前组合添加到结果列表中
        if (currentStr.length()  == n * 2){
            res.add(currentStr.toString());
            return;
        }
        // 如果左括号小于n， 那就加入左括号
        if (open<n){
            currentStr.append('(');
            backTraversal(res,currentStr,open+1,close,n);
            currentStr.deleteCharAt(currentStr.length()-1);
        }
        // 如果右括号小于左括号， 那就加入右括号
        if (close<open){
            currentStr.append(')');
            backTraversal(res,currentStr,open,close+1,n);
            currentStr.deleteCharAt(currentStr.length()-1);
        }
    }
}
