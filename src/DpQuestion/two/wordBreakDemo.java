package DpQuestion.two;

import java.util.HashSet;
import java.util.List;

public class wordBreakDemo {

    public boolean wordBreak(String s, List<String> wordDict) {

        HashSet hashSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        //先背包后物品
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                //如果dp[j]=true 而且hashset中包含(j,i)的子串就符合要求；
                if (dp[j] && hashSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
