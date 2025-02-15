package LiKoHot100.zichuan;

import java.util.HashSet;

public class lengthOfLongestSubstringDemo {

    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> hashSet = new HashSet<>();
        // 统计最长的
        int res =0;
        char[] charArray = s.toCharArray();
        // 左右指针的起点是一样的：一起向右滑动
        for (int left = 0, right =0; right <charArray.length ; right++) {
            char ch = charArray[right];
            while (hashSet.contains(ch)){
                // 移除左边界；左指针向右移动
                hashSet.remove(charArray[left]);
                left++;
            }
            // 没有重服就将右指针的值加入到set
            hashSet.add(charArray[right]);
            // 比较获取最大长度
            res = Math.max(res, right -left + 1);
        }
        return res;
    }
}
