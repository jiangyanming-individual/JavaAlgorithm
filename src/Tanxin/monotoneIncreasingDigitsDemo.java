package Tanxin;

public class monotoneIncreasingDigitsDemo {

    /**
     *
     *遇到前一个数字，比后一位数字大，前一位数字减一，后一位数字直接赋值为9
     * 从后往前遍历：str[i-1] > str[i] ,str[i-1] -- , str[i] =9;
     * @param n
     * @return
     */
    public int monotoneIncreasingDigits(int n){
        String s = String.valueOf(n);
        char[] charArray = s.toCharArray(); //转为字符数组；
        int start=charArray.length; //起始点为charArray.length 的话，就不用再使用
        // 从后往前
        for (int i=charArray.length -2;i>=0;i--){
            if (charArray[i] > charArray[i+1]){
                charArray[i] --;
                start= i +1; //后一个元素为起点
            }
        }

        for (int i= start;i<charArray.length;i++){
            charArray[i] ='9';
        }
        //最后转为int
        return  Integer.parseInt(String.valueOf(charArray));
    }

}
