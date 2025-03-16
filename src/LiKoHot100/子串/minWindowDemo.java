package LiKoHot100.子串;

public class minWindowDemo {

    /**
     * 最小覆盖子串
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {

        int sLen = s.length();
        int tLen= t.length();


        // 左指针
        int left=0;

        // 定义最小子串的左右指针：
        int resL= -1;
        int resR= sLen;

        // 转为字符数组
        char[]  sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();

        // ascall码的范围是0-255；
        int[] sTable = new int[256];
        int[] tTable=new int[256];

        //t字符串统计自己的字符出现的次数：
        for (int i=0;i<tLen;i++){
            tTable[tCharArray[i]]++;
        }

        // 进行遍历操作：右指针右移动
        for (int right =0;right<sLen;right++){
            //将元素加入到sTable中：
            sTable[sCharArray[right]]++;
            // 如果当前的滑动窗口还包含t，就移动左指针：
            while (isCover(sTable,tTable)){
                // 更新最小的边界：
                if (right -left < resR -resL){
                    resL= left;
                    resR =right;
                }
                // 缩小左边界，左指针往右移动：
                sTable[sCharArray[left]]--;
                left++;
            }
        }
        // 返回结果， 截取子串， （resL,resR+1）
        return  resL< 0 ? "" : s.substring(resL,resR +1);
    }

    //是否s含有t，统计词频即可
    public boolean isCover(int[] sTable, int[] tTable){

        for (int i='A';i<='Z';i++){
            if (sTable[i]< tTable[i]){
                return false;
            }
        }

        for (int i='a';i<='z';i++){
            if (sTable[i]< tTable[i]){
                return false;
            }
        }
        return true;
    }
}
