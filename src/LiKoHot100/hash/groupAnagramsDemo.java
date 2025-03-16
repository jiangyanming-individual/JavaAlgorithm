package LiKoHot100.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class groupAnagramsDemo {

    /**
     * 解题思路，就是相同的字母的字符串放在一起
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {

        // 存储key 和value结果
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {

            int[] tables = new int[26];
            int length= str.length();
            for (int i=0;i<length;i++){
                // 计数：
                tables[str.charAt(i) - 'a']++;
            }
            // 拼接key
            StringBuffer sb = new StringBuffer();
            for (int i=0;i<26;i++){
                if (tables[i] !=0){
                    // 字母 + 出现次数作为key
                    sb.append((char) 'a' + i);
                    sb.append(tables[i]);
                }
            }
            String key = sb.toString();
            List<String> list = hashMap.getOrDefault(key, new ArrayList<>());
            // 加入一个结果
            list.add(str);
            // 存放到hashmap中
            hashMap.put(key, list);
        }

        //返回结果
        return new ArrayList<>(hashMap.values());
    }
}
