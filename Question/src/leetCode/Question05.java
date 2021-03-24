package leetCode;

import java.io.ObjectInputStream;
import java.util.HashMap;

public class Question05 {
//    public static   String longestPalindrome(String s) {
//        if(s==" ") return " ";
//        int currentLength=0;
//        int maxLength=0;
//        int startIndex=0;
//        int endIndex=0;
//        HashMap<Character,Integer> map=new HashMap();
//        for(int i=0;i<s.length();i++){
//            char c=s.charAt(i);
//            if(map.containsKey(c)){
//                int lastIndex=map.get(s.charAt(i));
//                boolean a= check(s,lastIndex,i);
//                if (a){
//                    currentLength=i-lastIndex+1;
//                    if (currentLength>maxLength){
//                        maxLength=currentLength;
//                        startIndex=lastIndex;
//                        endIndex=i;
//                    }
//                }
//            }else{//map中不包含值, 说明没有出现
//                map.put(c,i);
//            }
//        }
//        StringBuilder sb=new StringBuilder();
//        for (int i=startIndex;i<=endIndex;i++){
//            char c=s.charAt(i);
//            sb.append(c);
//        }
//        return sb.toString();
//    }

    public static void main(String[] args) {
//        String s="cbbbbbbbbd";
//        String s="accccrabccacfr";
//        String s="aacabdkacaa";
//        String s1 = longestPalindrome(s);
//        System.out.println(s1);
        String str1 = "hello";
        String str2 = "he" + new String("llo");
        System.err.println(str1 == str2);
        Object o=new Object();
        o=0;
    }
}
