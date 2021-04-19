package question40.question48;

import java.util.*;

public class Question48_01 {
    static int maxLength(String s){
        if (s.equals("")) return 0;
        Queue<Character> queue=new LinkedList<>();
        int max=0;
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (queue.contains(c)){
                while (queue.poll()!=c);
                queue.add(c);
            }else {
                queue.add(c);
                if (max<queue.size()){
                    max=queue.size();
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s1=" ";
//        String s1="arabcacfr";
        int i = maxLength(s1);
        System.out.println(i);
    }
}
