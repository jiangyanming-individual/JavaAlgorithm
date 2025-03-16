package LiKoHot100.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class groupAnagramDemo2 {

    /**
     * 字母异位：求具有相同字母组成的元素
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            int[] tables = new int[26];
            int length= str.length();
            // 遍历单个元素：
            for (int i = 0; i < length; i++) {
                //计数
                tables[str.charAt(i) - 'a'] ++;
            }
            // key
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i <26 ; i++) {
                if (tables[i]!=0){
                    // 字母 + 出现次数
                    sb.append('a' - i);
                    sb.append(tables[i]);
                }
            }
            String key = sb.toString();
            List<String> list = hashMap.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            // 重新加入到里面
            hashMap.put(key,list);
        }
        // 将所有values都发给结果
        return new ArrayList<>(hashMap.values());
    }
}
