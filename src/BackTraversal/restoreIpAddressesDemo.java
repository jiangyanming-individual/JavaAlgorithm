package BackTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，
 * 这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 */
public class restoreIpAddressesDemo {

    List<String> result=new ArrayList<String>();
    //子串是全部都加上：
    public List<String> restoreIpAddresses(String s){

        if (s.length()> 12) return  result;
        backtraversal(s,0,0); //加入逗号的数量
        return result;
    }

    public void backtraversal(String s, int startIndex,int pointNum){
        //回溯终止条件：
        if (pointNum == 3){
            //判断第四段⼦字符串是否合法，如果合法就放进result中
            if (isValide(s,startIndex,s.length()-1)){//[start,end]
                result.add(s);
                return;
            }
        }
        //单层回溯
        for (int i=startIndex; i<s.length();i++){ //startIndex是切割点
            if (isValide(s,startIndex,i)){
                //i+1取不到,添加整条字符串：
                s=s.substring(0,i+1) + "." + s.substring(i+1); //拼接字符串；
                pointNum++;
                backtraversal(s,i+2,pointNum); //递归，加入逗号后，下一个切割点是i+2
                pointNum--; //回溯；
                s=s.substring(0,i+1) + s.substring(i+2);
            }else {
                break; //不符合条件直接break
            }
        }

    }
    public boolean isValide(String s,int start,int end){

        //以数字0开头的；
        if (start>end) return false;

       //(1) 以数字0开头的数字不合法； [start,end]
        if ((s.charAt(start) =='0') && (start != end)){
            return false;
        }

        int num=0;
        //(2) 遇到不再0-9之间的数字
        for (int i=start;i<=end; i++){
            if (s.charAt(i) <'0' || s.charAt(i)> '9'){//遇到非法字符
                return false;
            }
            //计算num
            num = num*10 + s.charAt(i) - '0';
            //(3)数字大于255的
            if (num > 255) return false;
        }
        //其他的就符合要求，返回true;
        return true;
    }
}
