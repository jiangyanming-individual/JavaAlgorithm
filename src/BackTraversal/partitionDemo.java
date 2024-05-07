package BackTraversal;

import java.util.ArrayList;
import java.util.List;

public class partitionDemo {

    List<List<String>> result=new ArrayList<List<String>>();
    List<String> path=new ArrayList<>();
    public List<List<String>> partition(String s){

        backtraversal(s,0);
        return result;
    }
    public void  backtraversal(String s, int startIndex){
        //回溯终止条件；切割的位置大于等于s.length
        if (startIndex >= s.length()){

            result.add(new ArrayList<>(path));
            return;
        }
        for (int i=startIndex;i<s.length();i++){

            //[startIndex,i] //i+1取不到
            if (isHuiwen(s,startIndex,i)){
                String substring = s.substring(startIndex, i - startIndex + 1);//因为从0开始；
                path.add(substring);
            }else {
                continue;
            }
            backtraversal(s,i+1); //递归 分隔符加1；
            path.remove(path.size() -1);
        }
    }
    public boolean isHuiwen(String s, int start, int end){
        // 双指针
        for (int i=start,j=end; i<j ; i++ ,j--){
            if (s.charAt(i) !=s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
