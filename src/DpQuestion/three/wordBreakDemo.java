package DpQuestion.three;

import java.util.HashSet;
import java.util.List;

public class wordBreakDemo {


    /**
     * 单词拆分：本地强调的是排列数，因为 （apple,pen, apple ）这个是有顺序的。
     *
     * 1. 背包容量是dp[s.size()+1]
     * 2. 物品是s.substring(i,j)
     * 3. 初始化dp: dp[0]=true, 递推公式： if(dp[i] = true && hashset.contain(s.substr(i,j))]) dp[j] =true
     * 4. 遍历顺序： 先遍历背包再遍历物品。
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {

        // 定义一个词典，hashset:
        HashSet<String> hashSet=new HashSet<>(wordDict);

        // 定义dp[i], 表示（0，i）长度的字符 能被字典中的元素组成：
        boolean [] dp =new boolean[s.length() +1];

        // 初始化；其他的初始化就是dp[i]=false
        dp[0]=true;
        // 先遍历背包：
        for (int j=1;j<=s.length();j++){
            // 物品
            for (int i=0;i<j;i++){
                String substring = s.substring(i, j);
                // 如果前面的(0,i)之前的都是true, 而且字典中也包含这个字符串
                if (dp[i] && hashSet.contains(substring)){
                    dp[j]= true;
                }
            }
        }
        // 返回结果
        return dp[s.length()];
    }



}
