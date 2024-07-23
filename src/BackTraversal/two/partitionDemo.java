package BackTraversal.two;

import java.util.ArrayList;
import java.util.List;

public class partitionDemo {


    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        traversal(s, 0);
        return result;
    }

    public void traversal(String s, int startIndex) {

        if (startIndex >= s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                //记录结果：
                String substring = s.substring(startIndex, i + 1);
                path.add(substring);
            } else {
                continue;
            }
            //递归
            traversal(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    //双指针判断回文数：
    public boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
