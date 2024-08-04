package Tanxin.three;

public class monotoneIncreasingDigitsDemo {


    /**
     * 单调递增的数字
     * @param n
     * @return
     */
    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        //转为字符数组
        char[] charArray = s.toCharArray();
        int flag=s.length();
        for (int i =charArray.length -2;i>=0;i--){
            if (charArray[i] > charArray[i+1]){
                //当前数值减一
                charArray[i] --;
                //标记
                flag=i+1;
            }
        }

        for (int i=flag;i<s.length();i++){
            //直接从标记的地址，往后直接设置为9；
            charArray[i] ='9';
        }
        //转为int
        return Integer.parseInt(String.valueOf(charArray));
    }
}
