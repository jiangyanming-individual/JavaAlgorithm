package LiKoHot100.子串;

public class minWindowDemo2 {



    public String minWindow(String s, String t) {

        int sLen= s.length();
        int tLen= t.length();
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();

        int left =0;
        int resL=-1;
        int resR=sLen;
        
        int[]  sTable= new int[256];
        int[] tTable = new int[256];
        
        // 遍历t字符串
        for (int i=0;i<tLen;i++){
            tTable[tCharArray[i]]++;
        }

        // 进行滑动窗口的移动
        for (int right =0;right<sLen;right++){
            // 对新的字母进行统计计数
            sTable[sCharArray[right]]++;
            while (isCover(sTable,tTable)){
                if (right - left< resR - resL){
                    resR= right;
                    resL= left;
                }
                // 左指针右移动；
                sTable[sCharArray[left]]--;
                left++;
            }
        }
        return resL < 0 ? "" : s.substring(resL, resR +1);
    }

    // 判断滑动窗口是否包含t字符
    public boolean isCover(int[] sTable, int[] tTable){

        for (int i='A'; i<='Z';i++){
            if (sTable[i]< tTable[i]){
                return  false;
            }
  
        }
        for (int i='a';i<='z';i++){
            if (sTable[i]< tTable[i])  {
                return false;
            }
        }
        return true;
    }

}
