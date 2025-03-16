package test;

public class Mian {


    public static void main(String[] args) {

        String str="userName"; // user_name
        String fun = fun(str);
        System.out.println(fun);
    }

    public  static  String fun(String str){
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<str.length();i++) {
            if (str.charAt(i) >= 'a' &&  str.charAt(i) <= 'z') {
                sb.append(str.charAt(i));
            } else {
                char ch = str.charAt(i);
                char lowerCase = Character.toLowerCase(ch);
                sb.append('_').append(lowerCase);
            }
        }
        return sb.toString();
    }
}


