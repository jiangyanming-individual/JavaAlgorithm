package Tanxin.three;

import netscape.security.UserTarget;

import java.util.*;

public class partitionLabelsDemo {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<Integer> list = partitionLabels(s);

        for (Integer i : list) {
            System.out.println(i);
        }

    }
    /**
     * 划分字母区间
     * 1. 先遍历数组，使用一个nums[26]的数组，进行统计最远的字母的index；
     * 2. 如果当前i == end 就进行取结果和更新下一个字符串的开始index;
     * @param s
     * @return
     */
    public static List<Integer> partitionLabels(String s) {

        List<Integer> result = new ArrayList<>();
        int [] set=new int[26];
        for (int i=0;i<s.length();i++){
            set[s.charAt(i)-'a']=i;
        }
        // start=0;
        int start=0;
        int end=0;
        for (int i=0;i<s.length();i++){
            // 更新最远的index；
            end=Math.max(end,set[s.charAt(i) -'a']);
            // 如果到达了最远的index
            if (i== end){
                // 取结果和更新start;
                result.add((end -start) +1);
                start=end+1;
            }
        }

        return result;
    }
}
