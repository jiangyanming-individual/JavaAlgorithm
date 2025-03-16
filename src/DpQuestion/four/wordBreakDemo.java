package DpQuestion.four;

import java.util.HashSet;
import java.util.List;

public class wordBreakDemo {


    /**
     * 单次拆分： 本题强调的是排列数，需要有顺序
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {

        HashSet<String> hashSet=new HashSet<>(wordDict);
        // 定义dp
        // 定义dp[i], 表示（0，i）长度的字符 能被字典中的元素组成：
        boolean [] dp =new boolean[s.length() +1];

        //初始化dp
        dp[0]=true;
        // 遍历：先遍历背包，再遍历物品；
        for (int j=1;j<=s.length();j++){
            for (int i=0;i<=j;i++){
                //组合物品 (i,j)
                String substring = s.substring(i, j);
                // 要保证：dp[i]已经是true， 而且剩下的子字符串也要在hashSet中
                if (dp[i] && hashSet.contains(substring)){
                    dp[j]=true;
                }
            }
        }
        // 返回结果：
        return dp[s.length()];
    }
}
