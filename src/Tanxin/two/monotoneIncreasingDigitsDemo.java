package Tanxin.two;

public class monotoneIncreasingDigitsDemo {

    /**
     * 单调递增的数字：
     *
     * @param n
     * @return
     */
    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        //转为字符数组
        char[] charArray = s.toCharArray();
        int flag = s.length();
        //当前数减一,如果大于等于0的话，就直接减去1：
        for (int i = s.length() - 2; i >= 0; i--) {
            if (charArray[i] > charArray[i + 1]) {
                charArray[i]--;
                flag = i + 1;
            }
        }
        //后一个数直接变为9；
        for (int j = flag; j < s.length(); j++) {
            charArray[j] = '9';
        }
        return Integer.parseInt(String.valueOf(charArray));
    }
}
