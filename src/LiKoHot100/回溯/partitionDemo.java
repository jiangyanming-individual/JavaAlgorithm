package LiKoHot100.回溯;

import java.util.ArrayList;
import java.util.List;

public class partitionDemo {


    /**
     * (1)需要判断是不是回文数，
     * (2) 如果是回文数，就可以将结果加入到结果集中
     */

    List<List<String>> res =new ArrayList<>();
    List<String> path =new ArrayList<>();

    public List<List<String>> partition(String s){

        backtraversal(s,0);
        return res;
    }

    public void backtraversal(String s, int startIndex){
        if (startIndex>=s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        // 遍历字符串：
        for (int i=startIndex;i<s.length();i++){
            if (isPalindrome(s,startIndex,i)){
                // 记录结果：(startIndex, i)
                String substring = s.substring(startIndex, i + 1);
                path.add(substring);
            }else {
                //不是就跳过：
                continue;
            }
            // 递归:
            backtraversal(s,i+1);
            // 回溯：
            path.remove(path.size()-1);
        }

    }
    /**
     * 判断是否为回文
     * @param s
     * @param start
     * @param end
     * @return
     */
    public  boolean isPalindrome(String s, int start,int end){

        for (int i=start,j=end; i<j;i++, j--){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
