package question30.question38;


import com.sun.jdi.StringReference;
import com.sun.jdi.event.StepEvent;

import java.net.Inet4Address;

public class Question38 {
    static void permutation(char[] str){
        if (str==null) return;
        int index=0;
        permutation(str,index);
    }
    static void permutation(char[] str,int index){
        if (index>=str.length) {
            System.out.println(str);
            return;
        }
        int leftNums=str.length-1-index;
        int subChars=index+1;
        permutation(str,subChars);
        while (leftNums>0 ){
            //这里使用完后需要交换,字符串内容的,不然会出现问题.
            exchange(str,index,leftNums+index);
            permutation(str,subChars);
            exchange(str,index,leftNums+index);
            leftNums--;
        }
    }
    private static void exchange(char[] str, int index, int indexToExchange) {
        char c = str[index];
        str[index]=str[indexToExchange];
        str[indexToExchange]=c;
    }

    public static void main(String[] args) {
        String str="";
        permutation(str.toCharArray());
//        String s2="1";
//        String s=new String("1");
//        s.intern();
//        System.out.println(s==s2);
//        String s3=new String("1")+new String("2");
//        String s4="12";
//        s3.intern();
//        System.out.println(s3==s4);

    }
}
